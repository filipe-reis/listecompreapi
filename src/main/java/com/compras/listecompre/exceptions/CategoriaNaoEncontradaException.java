package com.compras.listecompre.exceptions;

public class CategoriaNaoEncontradaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7415787635258552666L;
	
	public CategoriaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CategoriaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
