package com.tisv.agef.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.domain.Venda;
import com.tisv.agef.repositories.VendaRepository;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repo;
	
	@Autowired
	private PecaFeiraService pecaFeiraService;

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
		String nome = venda.getNome();
		String tamanho = venda.getTamanho();
		PecaFeira pecaFeira = pecaFeiraService.findByNomeAndTamanho(nome, tamanho);
		
		Integer qtdEstoque = pecaFeira.getQuantidade();
		Integer qtdVendida = venda.getQuantidade();
		
		if (qtdVendida > qtdEstoque) {
			throw new IllegalArgumentException("A quantidade de produtos vendidos deve ser menor ou igual a quantidade de produtos em estoque");
		}

		Integer qtdAtualizadaEstoque = qtdEstoque - qtdVendida;
		pecaFeira.setQuantidade(qtdAtualizadaEstoque);
		pecaFeiraService.insert(pecaFeira);
		
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
