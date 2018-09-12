package com.compras.listecompre.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.compras.listecompre.domain.Categoria;
import com.compras.listecompre.exceptions.CategoriaNaoEncontradaException;
import com.compras.listecompre.exceptions.ProdutoNaoEncontradoException;
import com.compras.listecompre.repository.CategoriasRepository;

@Service
public class CategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepository;
	
	public List<Categoria> listar(){
		return categoriasRepository.findAll();
	}
	
	public List<Categoria> listar(String nome){
		return categoriasRepository.findByNome(nome);
	}
	
	public Optional<Categoria> buscar(Long id){
		Optional<Categoria> categoria = categoriasRepository.findById(id);
		
		if(categoria == null) {
			throw new CategoriaNaoEncontradaException("Produto não encontrado!");
		}
		
		return categoria;
	}
	
	public Categoria salvar(Categoria categoria) {
		return categoriasRepository.save(categoria);
	}
	
	public void deletar(Long id) {
		try {	
			categoriasRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ProdutoNaoEncontradoException("O produto nao pôde ser encontrado para ser exluido");
		}
	}
	
	public void atualizar(Categoria categoria) {
		verificarExistencia(categoria);
		categoriasRepository.save(categoria);
	}

	private void verificarExistencia(Categoria categoria) {
		buscar(categoria.getCategoria_id());
	}

}
