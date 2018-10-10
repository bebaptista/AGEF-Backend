package com.tisv.agef.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tisv.agef.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{
	
	@Query("SELECT SUM(preco) FROM Venda WHERE data BETWEEN ?1 AND ?2")
	Double calculaFaturamento(LocalDate dataInicial, LocalDate dataFinal);
}
