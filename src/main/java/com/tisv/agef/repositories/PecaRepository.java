package com.tisv.agef.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tisv.agef.domain.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca,Integer>{}
