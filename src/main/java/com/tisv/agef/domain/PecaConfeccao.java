package com.tisv.agef.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class PecaConfeccao extends Modelo implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "É obrigatório o preenchimento do preço.")
	@Positive(message = "O campo 'preço' deve conter um valor maior do que zero.")
	private Double preco;

	@NotNull(message = "É obrigatório o preenchimento da quantidade de peças.")
	@Positive(message = "O campo 'quantidade' deve conter um valor maior do que zero.")
	private Integer quantidade;

	public PecaConfeccao() {
	}

	public PecaConfeccao(Modelo modelo, Double preco, Integer quantidade) {
		super(modelo.getNome(), modelo.getTamanho());
		this.preco = preco;
		this.quantidade = quantidade;
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
}
