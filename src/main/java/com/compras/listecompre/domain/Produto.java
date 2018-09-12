package com.compras.listecompre.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long produto_id;
	
	@Min(5)
	private Long codigo_barras; 
	
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "sku_id")
	private Sku sku;
	
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "mercado_id")
	private Mercado mercado;
	
//	@JsonFormat(pattern = "dd/MM/yyyy")
//	private Date dt_fabricacao;
//	
//	@JsonFormat(pattern = "dd/MM/yyyy")
//	private Date dt_validade;
	
		
	public Long getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(Long produto_id) {
		this.produto_id = produto_id;
	}
	public Mercado getMercado() {
		return mercado;
	}
	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Long getCodigo_barras() {
		return codigo_barras;
	}
	public void setCodigo_barras(Long codigo_barras) {
		this.codigo_barras = codigo_barras;
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
	
	
	public Sku getSku() {
		return sku;
	}
	public void setSku(Sku sku) {
		this.sku = sku;
	}
	
	
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	
	
//	public Date getDt_fabricacao() {
//		return dt_fabricacao;
//	}
//	public void setDt_fabricacao(Date dt_fabricacao) {
//		this.dt_fabricacao = dt_fabricacao;
//	}
//	
//	
//	public Date getDt_validade() {
//		return dt_validade;
//	}
//	public void setDt_validade(Date dt_validade) {
//		this.dt_validade = dt_validade;
//	}
	
	@Override
	public String toString() {
		return "codigo_barras.: "+ codigo_barras+"\n"+ 
				"nome..........: "+ nome         +"\n"+ 
				"descricao.....: "+ descricao    +"\n"+ 
				"preco.........: "+ preco        +"\n"+  
				"categoria.....: "+ categoria    +"\n"+ 
				"sku...........: "+ sku          +"\n"+
				"mercado.......: "+ mercado;
	}
	
	
}
