package com.tisv.agef.repositories.impl;

import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.repositories.custom.PecaFeiraRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PecaFeiraRepositoryImpl implements PecaFeiraRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public PecaFeira merge(PecaFeira pecaFeira) {
        return em.merge(pecaFeira);
    }
}