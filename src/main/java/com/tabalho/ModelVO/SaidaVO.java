package com.tabalho.ModelVO;

import java.util.Objects;

public class SaidaVO {
	
	private String tipo;
	private String data;
	private String hora;
	private double valor;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		return Objects.hash(data, hora, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaidaVO other = (SaidaVO) obj;
		return Objects.equals(data, other.data) && Objects.equals(hora, other.hora) && Objects.equals(tipo, other.tipo);
	}
	
	

}
