package com.tisv.agef.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tisv.agef.domain.Defeito;
import com.tisv.agef.services.DefeitoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/defeitos")
public class DefeitoResource {

	@Autowired
	private DefeitoService service;

	@ApiOperation(value = "Retorna o defeito correspondente ao parâmetro.", response = String.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Defeito defeito = service.find(id);
		return ResponseEntity.ok(defeito);
	}

	@ApiOperation(value = "Retorna todos os defeitos persistidos.", response = String.class)
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Defeito> defeitos = service.findAll();
		return ResponseEntity.ok(defeitos);
	}

	@ApiOperation(value = "Persiste o defeito enviado no corpo da requisição.", response = String.class)
	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody Defeito defeitoArg) {
		Defeito defeito = service.insert(defeitoArg);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(defeito.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Remove o defeito correspondente ao parâmetro.", response = String.class)
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
