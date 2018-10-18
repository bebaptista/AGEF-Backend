package com.tisv.agef.repositories;

import com.tisv.agef.domains.PecaFeira;
import com.tisv.agef.repositories.custom.PecaFeiraRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PecaFeiraRepository extends JpaRepository<PecaFeira, Integer>, PecaFeiraRepositoryCustom {

    @Query
    Optional<PecaFeira> findByModelo_NomeAndModelo_Tamanho(String nome, String tamanho);
}
