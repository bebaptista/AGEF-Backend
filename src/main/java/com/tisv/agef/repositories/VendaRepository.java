package com.tisv.agef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tisv.agef.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda,Integer>{}
