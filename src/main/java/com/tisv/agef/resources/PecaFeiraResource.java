package com.tisv.agef.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tisv.agef.domain.PecaFeira;
import com.tisv.agef.services.PecaFeiraService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/pecasfeira")
public class PecaFeiraResource {

	@Autowired
	private PecaFeiraService service;

	@ApiOperation(value = "Retorna a peça do estoque da feira correspondente ao parâmetro.", response = String.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		PecaFeira pecaFeira = service.find(id);
		return ResponseEntity.ok(pecaFeira);
	}

	@ApiOperation(value = "Retorna todas as peças persistidas no estoque da feira.", response = String.class)
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<PecaFeira> pecasFeira = service.findAll();
		return ResponseEntity.ok(pecasFeira);
	}

	@ApiOperation(value = "Persiste a peça do estoque da feira enviada no corpo da requisição.", response = String.class)
	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody PecaFeira pecaFeiraArg) {
		PecaFeira pecaFeira = service.insert(pecaFeiraArg);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pecaFeira.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Remove a peça do estoque da feira correspondente ao parâmetro.", response = String.class)
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza a peça do estoque da feira enviada no corpo da requisição.", response = String.class)
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody PecaFeira pecaFeira, @PathVariable Integer id) {
		service.update(pecaFeira, id);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		return ResponseEntity.badRequest().body(
				"Existe alguma peça associada ao modelo selecionado, edite ou remova a peça para realizar alterações."
						+ "\nErro:" + ex.toString());
	}
}
