package com.tabalho.ModelVO;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

public class VeiculoVO extends RepresentationModel<VeiculoVO> implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Mapping("id")
	private Long key;
	private String placa;
	private String cor;
	
	
	public Long getKey() {
		return key;
	}
	public void setId(Long key) {
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	

	
}
