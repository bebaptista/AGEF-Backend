package com.tisv.agef.repositories;

import com.tisv.agef.domains.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

    @Query
    List<Venda> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);
}
