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

import com.compras.listecompre.domain.Mercado;
import com.compras.listecompre.services.MercadosService;

@RestController
@RequestMapping("/mercados")
public class MercadosResources {

	@Autowired
	private MercadosService mercadosService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Mercado>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(mercadosService.listar());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(mercadosService.buscar(id));
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Mercado mercado){
		mercado = mercadosService.salvar(mercado);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(mercado.getMercado_id()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		mercadosService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Mercado mercado, @PathVariable("id") Long id){
		mercado.setMercado_id(id);
		mercadosService.atualizar(mercado);
		return ResponseEntity.noContent().build();
	}
}
