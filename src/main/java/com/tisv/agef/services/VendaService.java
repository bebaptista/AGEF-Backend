package com.tisv.agef.services;

import java.time.LocalDate;
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
				"Objeto não encontrado!" +
				"\n" + "Parâmetro: '"+ id + "'." +
				"\n" + "Tipo: '" + Venda.class.getName() + "'."));
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
	
	public Double calcularFaturamento(LocalDate dataInicial, LocalDate dataFinal){
		Double faturamento = repo.calcularFaturamento(dataInicial, dataFinal);
		return faturamento;
	}
}
