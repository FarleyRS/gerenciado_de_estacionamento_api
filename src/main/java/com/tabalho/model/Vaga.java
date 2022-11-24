package com.tabalho.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaga")
public class Vaga implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "numero", unique = true, nullable = false)
	private long numero;
	@Column(name = "idVeiculo")
	private long Idveiculo;

	
	public long getIdveiculo() {
		return Idveiculo;
	}

	public void setIdveiculo(long idveiculo) {
		Idveiculo = idveiculo;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	
}
