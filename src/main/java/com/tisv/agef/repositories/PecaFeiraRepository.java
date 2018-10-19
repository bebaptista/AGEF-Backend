package com.tisv.agef.repositories;

import com.tisv.agef.domains.PecaFeira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PecaFeiraRepository extends JpaRepository<PecaFeira, Integer> {

    @Query
    List<PecaFeira> findAllByDeletadoIsFalse();

    @Query
    Optional<PecaFeira> findByIdAndDeletadoIsFalse(Integer id);
}
