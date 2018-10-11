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

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Defeito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private int id;

	@ManyToOne
	@NotNull(message = "É obrigatório o preenchimento da peca feira.")
	@PrimaryKeyJoinColumn
	private PecaFeira pecaFeira;

	@NotNull(message = "É obrigatório o preenchimento da data da venda.")
	@PastOrPresent(message = "O campo 'data' deve conter uma data válida.")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate data;

	@NotNull(message = "É obrigatório o preenchimento da quantidade.")
	@Positive(message = "O campo 'quantidade' deve conter um valor maior do que zero.")
	private Integer quantidade;

	public Defeito() { }

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
