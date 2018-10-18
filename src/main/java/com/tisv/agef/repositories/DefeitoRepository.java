package com.tisv.agef.repositories;

import com.tisv.agef.domains.Defeito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefeitoRepository extends JpaRepository<Defeito, Integer> { }
