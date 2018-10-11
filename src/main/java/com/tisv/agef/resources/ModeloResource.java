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

import com.tisv.agef.domain.Modelo;
import com.tisv.agef.services.ModeloService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/modelos")
public class ModeloResource {

	@Autowired
	private ModeloService service;

	@ApiOperation(value = "Retorna o modelo correspondente ao parâmetro.", response = String.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Modelo modelo = service.find(id);
		return ResponseEntity.ok(modelo);
	}

	@ApiOperation(value = "Retorna todos os modelos persistidos.", response = String.class)
	@GetMapping()
	public ResponseEntity<?> findAll() {
		List<Modelo> modelos = service.findAll();
		return ResponseEntity.ok(modelos);
	}

	@ApiOperation(value = "Persiste o modelo enviado no corpo da requisição.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> insert(@Valid @RequestBody Modelo modeloArg) {
		Modelo modelo = service.insert(modeloArg);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(modelo.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Remove o modelo correspondente ao parâmetro.", response = String.class)
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza o modelo enviado no corpo da requisição.", response = String.class)
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Modelo modelo, @PathVariable Integer id) {
		service.update(modelo, id);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		return ResponseEntity.badRequest()
				.body("Existe alguma peça associada ao modelo selecionado, apague a peça antes de remover o modelo."
						+ "\nErro:" + ex.toString());
	}
}
