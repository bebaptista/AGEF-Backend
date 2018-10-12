package com.tisv.agef.repositories;

import com.tisv.agef.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

    @Query("SELECT SUM(preco * quantidade) FROM Venda WHERE data BETWEEN ?1 AND ?2")
    Double calcularFaturamento(LocalDate dataInicial, LocalDate dataFinal);
}
