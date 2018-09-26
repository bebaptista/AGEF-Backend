package com.tisv.agef.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tisv.agef.domain.Peca;
import com.tisv.agef.services.PecaService;

@RestController
@RequestMapping(value="/peca")
public class PecaResource {
	
	@Autowired
	private PecaService service;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public List<Peca> listarPecas() {
		return service.listarPecas();
	}
	
	@PostMapping(value="/adicionar")
	public void adicionarPeca(@RequestBody Peca peca){
		service.adicionarPeca(peca);
	}
	
	@DeleteMapping(value="/remover/{id}")
	public void removerPeca(@PathVariable Integer id){
		service.removerPeca(id);
	}
	/*
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<?> editarPeca(@RequestBody Peca peca, @PathVariable Integer id){
		service.editarPeca(id);
	}*/
	
}
