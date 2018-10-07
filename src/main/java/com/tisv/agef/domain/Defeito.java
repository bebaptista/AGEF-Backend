package com.tisv.agef.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import io.swagger.annotations.ApiModelProperty;

public class Defeito implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private int id;
	
	@OneToMany
	@PrimaryKeyJoinColumn
	private PecaFeira pecaFeira;
	
	private LocalDate data;
	
	private Integer quantidade;
	
	public Defeito() {}

	public Defeito(PecaFeira pecaFeira, LocalDate data, Integer quantidade) {
		super();
		this.pecaFeira = pecaFeira;
		this.data = data;
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
