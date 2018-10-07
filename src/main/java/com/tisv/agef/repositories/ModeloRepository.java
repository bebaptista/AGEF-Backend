package com.tisv.agef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tisv.agef.domain.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo,Integer>{}
