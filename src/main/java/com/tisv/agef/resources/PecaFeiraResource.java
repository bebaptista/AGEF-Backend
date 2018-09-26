package com.tisv.agef.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.services.PecaFeiraService;

@RestController
@RequestMapping(value="/pecaFeira")
public class PecaFeiraResource {
	
	@Autowired
	private PecaFeiraService service;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public List<PecaFeira> listarPecas() {
		return service.listarPecas();
	}
	
	@PostMapping(value="/adicionar")
	public void adicionarPeca(@RequestBody PecaFeira peca){
		service.adicionarPeca(peca);
	}
	
	@DeleteMapping(value="/remover/{id}")
	public void removerPeca(@PathVariable Integer id){
		service.removerPeca(id);
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<?> editarPeca(@RequestBody PecaFeira pecaFeira, @PathVariable Integer id){
		return service.editarPeca(pecaFeira, id);
	}
}
