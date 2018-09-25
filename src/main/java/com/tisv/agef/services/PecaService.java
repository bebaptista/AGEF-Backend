package com.tisv.agef.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisv.agef.domain.Peca;
import com.tisv.agef.repositories.PecaRepository;

@Service
public class PecaService {
	
	@Autowired
	private PecaRepository repo;

	public List<Peca> findAll(){
		List<Peca> objs = repo.findAll();
		return objs;
	}
	
}
