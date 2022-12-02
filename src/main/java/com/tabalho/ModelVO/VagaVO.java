package com.tabalho.ModelVO;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.tabalho.model.Veiculo;

public class VagaVO extends RepresentationModel<VagaVO> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long numero;
	private Veiculo veiculo;
	
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public String getVeiculo() {
		if(veiculo!=null) {
			return "Ocupada";
		}
		return "Vazia";
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
