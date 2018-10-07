package com.tisv.agef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisv.agef.domain.Venda;
import com.tisv.agef.repositories.VendaRepository;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repo;

	public Venda find(Integer id) {
		Optional<Venda> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Venda.class.getName()));
	}
	
	public List<Venda> findAll() {
		List<Venda> vendas = repo.findAll();
		return vendas;
	}

	public Venda insert(Venda venda) {
		return repo.save(venda);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public void update(Venda vendaArg, Integer id) {
		Optional<Venda> obj = repo.findById(id);

		if (obj.isPresent()) {
			Venda venda = obj.get();

			venda.setQuantidade(vendaArg.getQuantidade());

			repo.save(vendaArg);
		}
	}
}
