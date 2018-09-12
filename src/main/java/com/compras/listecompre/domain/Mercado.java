package com.compras.listecompre.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mercado")
public class Mercado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mercado_id;
	private String nome;
	private String descricao;
	private String cnpj;
	
	@OneToMany(cascade = CascadeType.ALL, 
			mappedBy = "mercado")
	@JsonIgnore
	private List<Produto> produtos;

	public Long getMercado_id() {
		return mercado_id;
	}

	public void setMercado_id(Long mercado_id) {
		this.mercado_id = mercado_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	
	
}
