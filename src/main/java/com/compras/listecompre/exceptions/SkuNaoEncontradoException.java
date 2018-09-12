package com.compras.listecompre.exceptions;

public class SkuNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7415787635258552666L;
	
	public SkuNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public SkuNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
