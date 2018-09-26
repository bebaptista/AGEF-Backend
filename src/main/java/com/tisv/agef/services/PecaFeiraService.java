package com.tisv.agef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tisv.agef.domain.Peca;
import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.repositories.PecaFeiraRepository;

@Service
public class PecaFeiraService {

	@Autowired
	private PecaFeiraRepository repo;

	public List<PecaFeira> listarPecas() {
		List<PecaFeira> objs = repo.findAll();
		return objs;
	}

	public void adicionarPeca(PecaFeira pecaFeira) {
		repo.save(pecaFeira);
	}

	public void removerPeca(Integer id) {
		repo.deleteById(id);
	}

	public ResponseEntity<?> editarPeca(PecaFeira pecaFeira, Integer id) {
		Optional<PecaFeira> obj = repo.findById(id);
		
		if (obj.isPresent()) {
			PecaFeira pFeira = obj.get();
			pFeira.setPreco(pecaFeira.getPreco());
			pFeira.setQuantidade(pecaFeira.getQuantidade());
			repo.save(pecaFeira);	
		}
		
		return ResponseEntity.noContent().build();
	}

}
