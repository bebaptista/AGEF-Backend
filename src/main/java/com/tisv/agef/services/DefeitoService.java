package com.tisv.agef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisv.agef.domain.Defeito;
import com.tisv.agef.repositories.DefeitoRepository;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;

@Service
public class DefeitoService {
	
	@Autowired
	private DefeitoRepository repo;

	public Defeito find(Integer id) {
		Optional<Defeito> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Defeito.class.getName()));
	}
	
	public List<Defeito> findAll() {
		List<Defeito> defeitos = repo.findAll();
		return defeitos;
	}

	public Defeito insert(Defeito defeito) {
		return repo.save(defeito);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
