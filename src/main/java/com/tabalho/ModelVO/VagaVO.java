package com.tabalho.ModelVO;

import com.tabalho.model.Veiculo;

public class VagaVO {
	
	private long numero;
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
