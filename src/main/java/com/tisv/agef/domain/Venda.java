package com.tisv.agef.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private int id;
	
	@OneToMany
	@PrimaryKeyJoinColumn
	private PecaFeira pecaFeira;
	
	private LocalDate data;
	
	private Double preco;
	
	private Integer quantidade;
	
	public Venda() {}

	public Venda(PecaFeira pecaFeira, LocalDate data, Double preco, Integer quantidade) {
		super();
		this.pecaFeira = pecaFeira;
		this.data = data;
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
