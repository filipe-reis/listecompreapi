package com.compras.listecompre.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.compras.listecompre.domain.Sku;
import com.compras.listecompre.exceptions.SkuNaoEncontradoException;
import com.compras.listecompre.repository.SkuRepository;

@Service
public class SkuService {
	
	@Autowired 
	private SkuRepository skuRepository;
	
	public List<Sku> listar(){
		return skuRepository.findAll();
	}
	
	public Optional<Sku> buscar(Long id){
		Optional<Sku> sku = skuRepository.findById(id);
		
		if(sku == null) {
			throw new SkuNaoEncontradoException("Sku não encontrado!");
		}
		
		return sku;
	}
	
	public Sku salvar(Sku sku) {
		return skuRepository.save(sku);
	}
	
	public void deletar(Long id) {
		try {	
			skuRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new SkuNaoEncontradoException("O sku nao pôde ser encontrado para ser exluido");
		}
	}
	
	public void atualizar(Sku sku) {
		verificarExistencia(sku);
		skuRepository.save(sku);
	}

	private void verificarExistencia(Sku sku) {
		buscar(sku.getSku_id());
	}

}
