package com.tisv.agef.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.services.PecaFeiraService;

@RestController
@RequestMapping(value = "/pecafeira")
public class PecaFeiraResource {

	@Autowired
	private PecaFeiraService service;

	@GetMapping
	public ResponseEntity<?> listarPecasFeira() {
		List<PecaFeira> pecasFeira = service.listarPecasFeira();
		return ResponseEntity.ok(pecasFeira);
	}

	@PostMapping
	public ResponseEntity<?> adicionarPecaFeira(@RequestBody PecaFeira pecaFeira) {
		service.adicionarPecaFeira(pecaFeira);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removerPecaFeira(@PathVariable Integer id) {
		service.removerPecaFeira(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> editarPecaFeira(@RequestBody PecaFeira pecaFeira, @PathVariable Integer id) {
		service.editarPecaFeira(pecaFeira, id);
		return ResponseEntity.noContent().build();
	}
}
