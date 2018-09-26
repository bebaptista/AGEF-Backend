package com.tisv.agef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisv.agef.domain.Peca;
import com.tisv.agef.repositories.PecaRepository;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;

@Service
public class PecaService {

	@Autowired
	private PecaRepository repo;

	public List<Peca> listarPecas() {
		List<Peca> objs = repo.findAll();
		return objs;
	}
	
	public void adicionarPeca(Peca peca){
		repo.save(peca);
	}

	public void removerPeca(Integer id) {
		repo.deleteById(id);
	}
	
	public ResponseEntity editarPeca(Integer id) {
		Optional<Peca> obj = repo.findById(id);
		if(!)
	}

}
