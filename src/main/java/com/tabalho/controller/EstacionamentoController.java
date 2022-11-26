package com.tabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tabalho.ModelVO.EntradaVO;
import com.tabalho.ModelVO.SaidaVO;
import com.tabalho.ModelVO.VagaVO;
import com.tabalho.model.ConfiguracaoEstacionamento;
import com.tabalho.model.EntradaVeiculo;
import com.tabalho.model.TabelaPreco;
import com.tabalho.model.Vaga;
import com.tabalho.services.EstacionamentoServices;
import com.tabalho.services.PrecoService;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	@Autowired
	EstacionamentoServices services;
	@Autowired
	PrecoService service;
	
	@RequestMapping(value = "/configuracao",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String config(@RequestBody ConfiguracaoEstacionamento config) {
		services.config(config);
		return String.valueOf(config.getLimitDeVagas());
	}
	
	@RequestMapping(value = "/listarVagas",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VagaVO> listarVagas(){
		return services.getVagas();
	}
	
	@RequestMapping(value = "/adicionarVeiculo",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public EntradaVO adicionarVeiculo(@RequestBody EntradaVeiculo eVeiculo) {
		return services.adicionarVeiculo(eVeiculo);
	}
	
	@RequestMapping(value = "/removerVeiculo",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public SaidaVO removerVeiculo(@RequestBody Long id) {
		return services.removerVeiculo(id);
	}
	
	@RequestMapping(value = "/adicionarTabela",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void adicionarTabela(@RequestBody TabelaPreco precoTabela) {
		service.adicionarPreco(precoTabela);
	}
	
	@RequestMapping(value = "/alterarTabela",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void alterarTabela(@RequestBody Long id) {
		service.alterarPreco(id);
	}
	
}
