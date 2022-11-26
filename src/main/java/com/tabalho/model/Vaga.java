package com.tabalho.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaga")
public class Vaga implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "numero", unique = true, nullable = false)
	private long numero;

	@OneToOne
	Veiculo veiculo;

	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	
}
