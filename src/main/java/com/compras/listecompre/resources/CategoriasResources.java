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

import com.compras.listecompre.domain.Categoria;
import com.compras.listecompre.services.CategoriasService;

@RestController
@RequestMapping("/categorias")
public class CategoriasResources {

	@Autowired
	private CategoriasService categoriasService;
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> listar(Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoriasService.listar());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(categoriasService.buscar(id));
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Categoria categoria){
		categoria = categoriasService.salvar(categoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(categoria.getCategoria_id()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		categoriasService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Categoria categoria, @PathVariable("id") Long id){
		categoria.setCategoria_id(id);
		categoriasService.atualizar(categoria);
		return ResponseEntity.noContent().build();
	}
	
}
