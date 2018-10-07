package com.tisv.agef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisv.agef.domain.Modelo;
import com.tisv.agef.repositories.ModeloRepository;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;

@Service
public class ModeloService {

	@Autowired
	private ModeloRepository repo;

	public Modelo find(Integer id) {
		Optional<Modelo> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Modelo.class.getName()));
	}
	
	public List<Modelo> findAll() {
		List<Modelo> objs = repo.findAll();
		return objs;
	}

	public Modelo insert(Modelo modelo) {
		return repo.save(modelo);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public void update(Modelo modelo, Integer id) {
		Optional<Modelo> obj = repo.findById(id);
		
		if (obj.isPresent()) {
			Modelo p = obj.get();
			
			p.setNome(modelo.getNome());
			p.setTamanho(modelo.getTamanho());
			
			repo.save(p);	
		}
	}
}
