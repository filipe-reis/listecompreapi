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

import com.compras.listecompre.domain.Produto;
import com.compras.listecompre.services.ProdutosService;

@RestController
@RequestMapping("/produtos")
public class ProdutosResources {
	
	@Autowired
	private ProdutosService produtosService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(produtosService.listar());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(produtosService.buscar(id));
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Produto produto){
		produto = produtosService.salvar(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(produto.getProduto_id()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		produtosService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Produto produto, @PathVariable("id") Long id){
		produto.setProduto_id(id);
		produtosService.atualizar(produto);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
