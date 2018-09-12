package com.compras.listecompre.exceptions;

public class MercadoNaoEncontradaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7415787635258552666L;
	
	public MercadoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public MercadoNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
