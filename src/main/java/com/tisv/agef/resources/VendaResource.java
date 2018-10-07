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

import com.tisv.agef.domain.Venda;
import com.tisv.agef.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {
	
	@Autowired
	private VendaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Venda venda = service.find(id);
		return ResponseEntity.ok(venda);
	}
	
	@GetMapping()
	public ResponseEntity<?> findAll() {
		List<Venda> vendas = service.findAll();
		return ResponseEntity.ok(vendas);
	}
	
	@PostMapping()
	public ResponseEntity<?> insert(@RequestBody Venda vendaArg) {
		Venda venda = service.insert(vendaArg);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(venda.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@RequestBody Venda venda, @PathVariable Integer id) {
		service.update(venda, id);
		return ResponseEntity.noContent().build();
	}
}
