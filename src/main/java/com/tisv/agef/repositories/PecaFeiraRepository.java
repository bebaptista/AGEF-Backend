package com.tisv.agef.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tisv.agef.domain.PecaFeira;

@Repository
public interface PecaFeiraRepository extends JpaRepository<PecaFeira, Integer>{ 
	
	Optional<PecaFeira> findByNomeAndTamanho(String nome, String tamanho);
	
}
