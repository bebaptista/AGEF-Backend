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

	public Peca find(Integer id) {
		Optional<Peca> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Peca.class.getName()));
	}
	
	public List<Peca> findAll() {
		List<Peca> objs = repo.findAll();
		return objs;
	}

	public Peca insert(Peca peca) {
		return repo.save(peca);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public void update(Integer id, Peca peca) {
		Optional<Peca> obj = repo.findById(id);
		
		if (obj.isPresent()) {
			Peca p = obj.get();
			
			p.setNome(peca.getNome());
			p.setTamanho(peca.getTamanho());
			
			repo.save(p);	
		}
	}
}
