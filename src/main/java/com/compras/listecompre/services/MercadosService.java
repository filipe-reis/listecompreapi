package com.compras.listecompre.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.compras.listecompre.domain.Mercado;
import com.compras.listecompre.exceptions.MercadoNaoEncontradaException;
import com.compras.listecompre.exceptions.ProdutoNaoEncontradoException;
import com.compras.listecompre.repository.MercadosRepository;

@Service
public class MercadosService {
	
	@Autowired
	private MercadosRepository mercadoRepository;
	
	public List<Mercado> listar(){
		return mercadoRepository.findAll();
	}
	
	public Optional<Mercado> buscar(Long id){
		Optional<Mercado> mercado = mercadoRepository.findById(id);
		
		if(mercado == null) {
			throw new MercadoNaoEncontradaException("Produto não encontrado!");
		}
		
		return mercado;
	}
	
	public Mercado salvar(Mercado mercado) {
		return mercadoRepository.save(mercado);
	}
	
	public void deletar(Long id) {
		try {	
			mercadoRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ProdutoNaoEncontradoException("O produto nao pôde ser encontrado para ser exluido");
		}
	}
	
	public void atualizar(Mercado mercado) {
		verificarExistencia(mercado);
		mercadoRepository.save(mercado);
	}

	private void verificarExistencia(Mercado mercado) {
		buscar(mercado.getMercado_id());
	}

}
