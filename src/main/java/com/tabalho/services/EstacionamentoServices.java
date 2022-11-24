package com.tabalho.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabalho.ModelVO.EntradaVO;
import com.tabalho.ModelVO.SaidaVO;
import com.tabalho.model.ConfiguracaoEstacionamento;
import com.tabalho.model.EntradaVeiculo;
import com.tabalho.model.Movimento;
import com.tabalho.model.Vaga;
import com.tabalho.model.Veiculo;
import com.tabalho.repository.VagaRepository;
import com.tabalho.repository.VeiculoRepository;


@Service
public class EstacionamentoServices {

	private ConfiguracaoEstacionamento configuracao = new ConfiguracaoEstacionamento();
	private Vaga vaga;

	@Autowired
	VagaRepository repository;
	
	@Autowired
	VeiculoRepository veRepository;
	
	public void config(ConfiguracaoEstacionamento config) {
		configuracao.setLimitDeVagas(config.getLimitDeVagas());
		criarVagas();
	}

	private void criarVagas(){
		for(int i=0;i<configuracao.getLimitDeVagas();i++) {
			vaga = new Vaga();
			vaga.setNumero(i);
			repository.save(vaga);
		}
	}
	
	public EntradaVO adicionarVeiculo(EntradaVeiculo eVeiculo) {
		EntradaVO entrada = new EntradaVO();
		Movimento movimento = new Movimento();
		movimento.setTipo(1);
		
		long id = eVeiculo.getIdVaga();
		Veiculo veiculo = eVeiculo.getVeiculo();
		
		Veiculo reVeiculo = veRepository.save(veiculo);
		Optional<Vaga> vaga = repository.findById(id);
		
		if(vaga.isPresent()) {
			Vaga reVaga = vaga.get();
			reVaga.setIdveiculo(reVeiculo.getId());
			
			repository.save(reVaga);
		}
		
		entrada.setData(movimento.getData());
		entrada.setHora(movimento.getHora());
		entrada.setTipo(movimento.getTipo());
		
		
		return entrada;
	}
		
	public SaidaVO removerVeiculo(Long idVaga) {
		Movimento movimento = new Movimento();
		SaidaVO saidaVO = new SaidaVO();
		movimento.setTipo(0);
	
		Optional<Vaga> vaga = repository.findById(idVaga);
		if(vaga.isPresent()) {
			Vaga reVaga = vaga.get();
			
			reVaga.setIdveiculo(0);
			
			repository.save(reVaga);
		}
		
		saidaVO.setTipo(movimento.getTipo());
		saidaVO.setHora(movimento.getHora());
		saidaVO.setData(movimento.getData());
		saidaVO.setValor(movimento.getValorHora());
		
		return saidaVO;
	}
	
	public List<Vaga> getVagas() {
		return repository.findAll();
	}
	
	
}
