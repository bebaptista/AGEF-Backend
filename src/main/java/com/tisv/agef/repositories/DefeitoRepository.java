package com.tisv.agef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tisv.agef.domain.Defeito;

@Repository
public interface DefeitoRepository extends JpaRepository<Defeito,Integer>{}
