package com.tisv.agef.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PecaFeira implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private int id;
	
	private Double preco;
	
	private Integer quantidade;
	
	@OneToOne
	private Peca peca;
	
	public PecaFeira() { }

	public PecaFeira(Peca peca, Double preco, Integer quantidade) {
		super();
		this.peca = peca;
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
	
	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((peca == null) ? 0 : peca.hashCode());
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
		if (peca == null) {
			if (other.peca != null)
				return false;
		} else if (!peca.equals(other.peca))
			return false;
		return true;
	}
}
