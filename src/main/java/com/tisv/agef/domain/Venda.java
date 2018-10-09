package com.tisv.agef.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private int id;
	
	@NotNull(message="É obrigatório o preenchimento da peça da feira.")
	@ManyToOne
	@PrimaryKeyJoinColumn
	private PecaFeira pecaFeira;
	
	@NotNull(message="É obrigatório o preenchimento da data da venda.")
	@PastOrPresent(message="O campo 'data' deve conter uma data válida.")
	private LocalDate data;
	
	@NotNull(message="É obrigatório o preenchimento do preço.")
	@Positive(message="O campo 'preço' deve conter um valor maior do que zero.")
	private Double preco;
	
	@NotNull(message="É obrigatório o preenchimento da quantidade vendida.")
	@Positive(message="O campo 'quantidade' deve conter um valor maior do que zero.")
	private Integer quantidade;
	
	public Venda() {}

	public Venda(PecaFeira pecaFeira, Double preco, Integer quantidade) {
		super();
		this.pecaFeira = pecaFeira;
		this.data = LocalDate.now();
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public PecaFeira getPecaFeira() {
		return pecaFeira;
	}

	public void setPecaFeira(PecaFeira pecaFeira) {
		this.pecaFeira = pecaFeira;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}
}
