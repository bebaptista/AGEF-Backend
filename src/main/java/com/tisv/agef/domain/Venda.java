package com.tisv.agef.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private int id;
	
	@NotBlank(message="É obrigatório o preenchimento do nome.")
	private String nome;
	
	@NotBlank(message="É obrigatório o preenchimento do tamanho.")
	private String tamanho;
	
	@NotNull(message="É obrigatório o preenchimento do preço.")
	@Positive(message="O campo 'preço' deve conter um valor maior do que zero.")
	private Double preco;
	
	@NotNull(message="É obrigatório o preenchimento da quantidade vendida.")
	@Positive(message="O campo 'quantidade' deve conter um valor maior do que zero.")
	private Integer quantidade;
	
	@NotNull(message="É obrigatório o preenchimento da data da venda.")
	@PastOrPresent(message="O campo 'data' deve conter uma data válida.")
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate data;
	
	public Venda() {}

	public Venda(Double preco, String nome, String tamanho, Integer quantidade, LocalDate data) {
		this.preco = preco;
		this.nome = nome;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}
}
