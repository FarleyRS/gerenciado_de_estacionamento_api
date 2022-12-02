package com.tabalho.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="preco")
public class TabelaPreco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "valorUteis",nullable = false, length = 25)
	private Double valorUteis;
	@Column(name = "valorFimdeSemana",nullable = false, length = 25)
	private Double valorFimDeSemana;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValorUteis() {
		return valorUteis;
	}
	public void setValorUteis(Double valorUteis) {
		this.valorUteis = valorUteis;
	}
	public Double getValorFimDeSemana() {
		return valorFimDeSemana;
	}
	public void setValorFimDeSemana(Double valorFimDeSemana) {
		this.valorFimDeSemana = valorFimDeSemana;
	}
}