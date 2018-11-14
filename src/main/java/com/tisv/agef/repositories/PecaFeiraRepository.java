package com.tisv.agef.repositories;

import com.tisv.agef.domains.Modelo;
import com.tisv.agef.domains.PecaFeira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface PecaFeiraRepository extends JpaRepository<PecaFeira, Integer> {

    @Query
    List<PecaFeira> findAllByDeletadoIsFalse();

    @Query
    Optional<PecaFeira> findByIdAndDeletadoIsFalse(Integer id);

    @Query
    Optional<PecaFeira> findByModeloAndDeletado(Modelo modelo, Boolean foiDeletado);

    @Transactional
    @Modifying()
    @Query(value = "UPDATE PECA_FEIRA p SET p.quantidade = (SELECT quantidade + ?2 FROM PECA_FEIRA WHERE ID = ?1) WHERE p.id = ?1", nativeQuery = true)
    void updateByIdSumQuantity(Integer id, Integer qtdVendida);
}
