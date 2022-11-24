package com.tabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tabalho.model.TabelaPreco;

@Repository
public interface TabelaPrecoRepository  extends JpaRepository<TabelaPreco, Long>{
	
}
