package com.compras.listecompre.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.compras.listecompre.domain.Mercado;
import com.compras.listecompre.domain.Produto;
import com.compras.listecompre.exceptions.ProdutoNaoEncontradoException;
import com.compras.listecompre.repository.ProdutosRepository;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	
	public List<Produto> listar(){
		return produtosRepository.findAll();
	}
	
	public Optional<Produto> buscar(Long id){
		Optional<Produto> produto = produtosRepository.findById(id);
		
		if(produto == null) {
			throw new ProdutoNaoEncontradoException("Produto não encontrado!");
		}
		
		return produto;
	}
	
	public Produto salvar(Produto produto) {
		produto.getMercado();
		return produtosRepository.save(produto);
	}
	
	public void deletar(Long id) {
		try {	
			produtosRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ProdutoNaoEncontradoException("O produto nao pôde ser encontrado para ser exluido");
		}
	}
	
	public void atualizar(Produto produto) {
		verificarExistencia(produto);
		produtosRepository.save(produto);
	}

	private void verificarExistencia(Produto produto) {
		buscar(produto.getProduto_id());
	}
	
}
