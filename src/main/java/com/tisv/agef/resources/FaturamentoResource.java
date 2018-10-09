package com.tisv.agef.resources;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tisv.agef.services.FaturamentoService;

@RestController
@RequestMapping(value = "/vendas/faturamento")
public class FaturamentoResource {
	
	@Autowired
	private FaturamentoService service;
	
	@GetMapping
	public ResponseEntity<?> calculaFaturamento(@RequestParam(value = "dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, @RequestParam(value = "dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		Double faturamento = service.calculaFaturamento(dataInicial, dataFinal);
		return ResponseEntity.ok(faturamento);
	}
}
