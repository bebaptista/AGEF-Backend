package com.tisv.agef.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames= {"MODELO_ID"})})
public class PecaFeira implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private int id;
	
	@NotNull(message="É obrigatório o preenchimento do preço.")
	@Positive(message="O campo 'preço' deve conter um valor maior do que zero.")
	private Double preco;
	
	@NotNull(message="É obrigatório o preenchimento da quantidade de peças.")
	@Positive(message="O campo 'quantidade' deve conter um valor maior do que zero.")
	private Integer quantidade;
	
	@NotNull(message="É obrigatório o preenchimento do modelo.")
	@OneToOne
	private Modelo modelo;
	
	public PecaFeira() { }

	public PecaFeira(Modelo modelo, Double preco, Integer quantidade) {
		super();
		this.modelo = modelo;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
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
	
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PecaFeira other = (PecaFeira) obj;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}
}
