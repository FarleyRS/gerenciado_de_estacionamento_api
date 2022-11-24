package com.tabalho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tabalho.model.TabelaPreco;
import com.tabalho.repository.TabelaPrecoRepository;

@Service
public class PrecoService {
	
	@Autowired
	TabelaPrecoRepository repository;
	
	double preco;
	
	
	public void adicionarPreco(TabelaPreco tabelaPreco) {
		repository.save(tabelaPreco);		
	}
	
	public void alterarPreco(Long id) {
		Optional<TabelaPreco> tabela = repository.findById(id);
		if(tabela.isPresent()) {
			TabelaPreco altTab = tabela.get();
			repository.save(altTab);
		}
	}
	
	public List<TabelaPreco> getPreco() {
		return repository.findAll();
	}
	
}
