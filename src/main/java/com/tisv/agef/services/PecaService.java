package com.tisv.agef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisv.agef.domain.Peca;
import com.tisv.agef.repositories.PecaRepository;

@Service
public class PecaService {

	@Autowired
	private PecaRepository repo;

	public List<Peca> listarPecas() {
		List<Peca> objs = repo.findAll();
		return objs;
	}

	public void adicionarPeca(Peca peca) {
		repo.save(peca);
	}

	public void removerPeca(Integer id) {
		repo.deleteById(id);
	}

	public void editarPeca(Integer id, Peca peca) {
		Optional<Peca> obj = repo.findById(id);
		
		if (obj.isPresent()) {
			Peca p = obj.get();
			
			p.setNome(peca.getNome());
			p.setTamanho(peca.getTamanho());
			
			repo.save(p);	
		}
	}
}
