package com.tabalho.model;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;

public class Estacionamento {
	@Autowired
	Movimento movimento;
	@Autowired
	Veiculo veiculo;
	private LocalDateTime registroHoraEData;
	
	public void relatorioVeiculo() {
	 	entradaVeiculo();
		 saidaVeiculo();
	}
	
	public void updateVaga(Movimento movimento) {}
	
	public Long entradaVeiculo() {
		movimento.setTipo(1);
		return veiculo.getId();
	}
	
	public LocalDateTime saidaVeiculo() {
	    registroHoraEData = LocalDateTime.now(ZoneId.of("UTC")); //registra a data e o horario
		movimento.setTipo(0);
		return registroHoraEData;
	}
	
	
}
