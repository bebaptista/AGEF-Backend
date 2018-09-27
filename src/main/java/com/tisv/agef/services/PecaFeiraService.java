package com.tisv.agef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.repositories.PecaFeiraRepository;

@Service
public class PecaFeiraService {

	@Autowired
	private PecaFeiraRepository repo;

	public List<PecaFeira> listarPecasFeira() {
		List<PecaFeira> pecasFeira = repo.findAll();
		return pecasFeira;
	}

	public void adicionarPecaFeira(PecaFeira pecaFeira) {
		repo.save(pecaFeira);
	}

	public void removerPecaFeira(Integer id) {
		repo.deleteById(id);
	}

	public void editarPecaFeira(PecaFeira pecaFeiraArg, Integer id) {
		Optional<PecaFeira> obj = repo.findById(id);

		if (obj.isPresent()) {
			PecaFeira pecaFeira = obj.get();

			pecaFeira.setPreco(pecaFeiraArg.getPreco());
			pecaFeira.setQuantidade(pecaFeiraArg.getQuantidade());

			repo.save(pecaFeiraArg);
		}
	}

}
