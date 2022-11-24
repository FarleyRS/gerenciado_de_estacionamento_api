package com.tabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tabalho.model.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long>{
	
	
	
}