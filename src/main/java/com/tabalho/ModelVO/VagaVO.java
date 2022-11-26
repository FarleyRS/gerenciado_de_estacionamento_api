package com.tabalho.ModelVO;

public class VagaVO {
	
	private long numero;
	private long Idveiculo;
	
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public String getIdveiculo() {
		if(Idveiculo!=0) {
			return "Ocupada";
		}
		return "Vazia";
	}
	public void setIdveiculo(long idveiculo) {
		Idveiculo = idveiculo;
	}
	
	
}
