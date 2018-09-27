package com.tisv.agef.resources;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.tisv.agef.domain.Peca;
import com.tisv.agef.services.PecaService;

@RestController
@RequestMapping(value = "/peca")
public class PecaResource {

	@Autowired
	private PecaService service;

	@GetMapping()
	public ResponseEntity<?> listarPecas() {
		List<Peca> pecas = service.listarPecas();
		return ResponseEntity.ok(pecas);
	}

	@PostMapping()
	public ResponseEntity<?> adicionarPeca(@RequestBody Peca peca) {
		service.adicionarPeca(peca);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removerPeca(@PathVariable Integer id) {
		service.removerPeca(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> editarPeca(@PathVariable Integer id, @RequestBody Peca peca) {
		service.editarPeca(id, peca);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		return ResponseEntity.badRequest().body("Existe alguma constraint na entidade sendo utilizada.");
	}
}
