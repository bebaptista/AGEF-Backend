package com.tisv.agef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.repositories.PecaFeiraRepository;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;

@Service
public class PecaFeiraService {

	@Autowired
	private PecaFeiraRepository repo;

	public PecaFeira find(Integer id) {
		Optional<PecaFeira> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!" +
				"\n" + "Parâmetro: '"+ id + "'." +
				"\n" + "Tipo: '" + PecaFeira.class.getName() + "'."));
	}
	
	public List<PecaFeira> findAll() {
		List<PecaFeira> pecasFeira = repo.findAll();
		return pecasFeira;
	}

	public PecaFeira insert(PecaFeira pecaFeira) {
		return repo.save(pecaFeira);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public void update(PecaFeira pecaFeiraArg, Integer id) {
		Optional<PecaFeira> obj = repo.findById(id);

		if (obj.isPresent()) {
			PecaFeira pecaFeira = obj.get();

			pecaFeira.setPreco(pecaFeiraArg.getPreco());
			pecaFeira.setQuantidade(pecaFeiraArg.getQuantidade());

			repo.save(pecaFeiraArg);
		}
	}

}
