package com.tisv.agef.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.services.PecaFeiraService;

@RestController
@RequestMapping(value = "/pecafeira")
public class PecaFeiraResource {

	@Autowired
	private PecaFeiraService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		PecaFeira pecaFeira = service.find(id);
		return ResponseEntity.ok(pecaFeira);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<PecaFeira> pecasFeira = service.findAll();
		return ResponseEntity.ok(pecasFeira);
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody PecaFeira pecaFeiraArg) {
		PecaFeira pecaFeira = service.insert(pecaFeiraArg);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(pecaFeira.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@RequestBody PecaFeira pecaFeira, @PathVariable Integer id) {
		service.update(pecaFeira, id);
		return ResponseEntity.noContent().build();
	}
}
