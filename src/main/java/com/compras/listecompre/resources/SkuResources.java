package com.compras.listecompre.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compras.listecompre.domain.Sku;
import com.compras.listecompre.services.SkuService;

@RestController
@RequestMapping("/sku")
public class SkuResources {
	
	@Autowired
	private SkuService skuServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sku>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(skuServices.listar());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(skuServices.buscar(id));
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Sku sku){
		sku = skuServices.salvar(sku);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(sku.getSku_id()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		skuServices.deletar(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Sku sku, @PathVariable("id") Long id){
		sku.setSku_id(id);
		skuServices.atualizar(sku);
		return ResponseEntity.noContent().build();
	}

}
