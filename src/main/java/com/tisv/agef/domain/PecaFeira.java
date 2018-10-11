package com.tisv.agef.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "NOME", "TAMANHO" }) })
public class PecaFeira extends Modelo implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "É obrigatório o preenchimento do preço.")
	@Positive(message = "O campo 'preço' deve conter um valor maior do que zero.")
	@ApiModelProperty(value = "Preço da peça no estoque da feira.", example = "45.50", allowableValues = "range[0.01, infinity]", required = true)
	private Double preco;

	@NotNull(message = "É obrigatório o preenchimento da quantidade de peças.")
	@PositiveOrZero(message = "O campo 'quantidade' deve conter um valor maior ou igual à zero.")
	@ApiModelProperty(value = "Quantidade de peças no estoque da feira.", example = "25", allowableValues = "range[0, infinity]", required = true)
	private Integer quantidade;

	public PecaFeira() { }

	public PecaFeira(Modelo modelo, Double preco, Integer quantidade) {
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
