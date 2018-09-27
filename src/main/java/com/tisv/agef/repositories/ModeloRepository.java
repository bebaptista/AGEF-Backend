package com.tisv.agef.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tisv.agef.domain.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo,Integer>{}
