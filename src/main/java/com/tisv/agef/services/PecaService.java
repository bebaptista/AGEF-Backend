package com.tisv.agef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	public void adicionarPeca(Peca peca){
		repo.save(peca);
	}

	public void removerPeca(Integer id) {
		repo.deleteById(id);
	}
	
	public ResponseEntity<?> editarPeca(Peca peca,Integer id) {
		Optional<Peca> obj = repo.findById(id);
		if(!obj.isPresent()){
			return ResponseEntity.notFound().build();
		}	
		else{
			Peca p = obj.get();
			p.setNome(peca.getNome());
			p.setTamanho(peca.getTamanho());
			repo.save(p);
			return ResponseEntity.noContent().build();
		}
	}

}
