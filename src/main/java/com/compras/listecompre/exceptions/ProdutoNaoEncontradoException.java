package com.compras.listecompre.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7415787635258552666L;
	
	public ProdutoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ProdutoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
