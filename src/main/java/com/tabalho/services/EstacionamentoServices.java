package com.tabalho.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabalho.ModelVO.EntradaVO;
import com.tabalho.ModelVO.SaidaVO;
import com.tabalho.ModelVO.VagaVO;
import com.tabalho.ModelVO.VeiculoVO;
import com.tabalho.controller.EstacionamentoController;
import com.tabalho.mapper.DozerMapper;
import com.tabalho.model.ConfiguracaoEstacionamento;
import com.tabalho.model.EntradaVeiculo;
import com.tabalho.model.Movimento;
import com.tabalho.model.Vaga;
import com.tabalho.model.Veiculo;
import com.tabalho.repository.ModeloRepository;
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
	
	@Autowired
	ModeloRepository moRepository;
	
	public List<VeiculoVO> listarVeiculos(){
		
		var veiculo= veRepository.findAll();
		var veiculoVO = DozerMapper.parseListObjects(veiculo, VeiculoVO.class);
		
		veiculoVO
		.stream()
		.forEach(p -> 
		p.add(linkTo(EstacionamentoController.class).slash(p.getKey()).withRel("detalhes")));	
		return veiculoVO;
	}
	
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
		
		long id = eVeiculo.getNumeroVaga();
		Veiculo veiculo = eVeiculo.getVeiculo();
		moRepository.save(eVeiculo.getVeiculo().getModelo());
		Veiculo reVeiculo = veRepository.save(veiculo);
		
		Optional<Vaga> vaga = repository.findById(id);
		
		if(vaga.isPresent()) {
			Vaga reVaga = vaga.get();
			reVaga.setVeiculo(reVeiculo);
			
			repository.save(reVaga);
		}
		
		entrada.setData(movimento.getData());
		entrada.setHora(movimento.getHora());
		entrada.setTipo(movimento.getTipo());
		
		
		return entrada;
	}
		
	public String removerVeiculo(Long idVaga) {
		Movimento movimento = new Movimento();
		SaidaVO saidaVO = new SaidaVO();
		movimento.setTipo(0);
	
		Optional<Vaga> vaga = repository.findById(idVaga);
		if(vaga.isPresent()) {
			Vaga reVaga = vaga.get();
			if(!reVaga.getVeiculo().equals(null)) {
				reVaga.setVeiculo(null);
				repository.save(reVaga);
				
			}
			
		}
		
		saidaVO.setTipo(movimento.getTipo());
		saidaVO.setHora(movimento.getHora());
		saidaVO.setData(movimento.getData());
		saidaVO.setValor(movimento.getValorHora());
		
		return saidaVO.toString();
	}
	
	public List<VagaVO> getVagas() {
		List<Vaga> vagas = repository.findAll();
		
		List<VagaVO> vagasVO = new ArrayList<>();
		
		for(int i=0;i<vagas.size();i++) {
			VagaVO v = new VagaVO();
			v.setNumero(vagas.get(i).getNumero());
			v.setVeiculo(vagas.get(i).getVeiculo());
			vagasVO.add(v);
		}
 		return vagasVO;
	}
	
}
