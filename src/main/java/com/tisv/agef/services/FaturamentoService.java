package com.tisv.agef.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisv.agef.repositories.VendaRepository;

@Service
public class FaturamentoService {
	
	@Autowired
	private VendaRepository repo;
	
	public Double calculaFaturamento(LocalDate dataInicial, LocalDate dataFinal){
		Double faturamento = repo.calculaFaturamento(dataInicial, dataFinal);
		return faturamento;
	}
	
}
