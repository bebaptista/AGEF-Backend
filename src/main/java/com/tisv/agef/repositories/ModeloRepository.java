package com.tisv.agef.repositories;

import com.tisv.agef.domains.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

    @Query
    List<Modelo> findAllByDeletadoFalse();
}
