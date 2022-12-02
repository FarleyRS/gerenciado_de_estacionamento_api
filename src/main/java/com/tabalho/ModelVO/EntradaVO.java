package com.tabalho.ModelVO;

import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;

public class EntradaVO extends RepresentationModel<EntradaVO> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private String data;
	private String hora;
	
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
}
