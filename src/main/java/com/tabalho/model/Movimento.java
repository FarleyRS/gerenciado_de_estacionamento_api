package com.tabalho.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Movimento {
	
	Date dataHoraAtual = new Date();
	
	private String tipo;
	
	private String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
	
	private String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

	private double valorHora;


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		if(tipo==1) {
			this.tipo = "Entrada";
		}else {
			this.tipo = "Saida";
		}
	}
	
	
}
