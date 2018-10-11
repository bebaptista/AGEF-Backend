package com.tisv.agef.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.tisv.agef.domain.Defeito;
import com.tisv.agef.resources.helpers.ExceptionMessages;
import com.tisv.agef.services.DefeitoService;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/defeitos")
public class DefeitoResource {

	@Autowired
	private DefeitoService service;

	@ApiOperation(value = "Retorna o defeito correspondente ao parâmetro.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 404, message = "Not Found. O objeto solicitado não foi encontrado no servidor.")
	})
	@GetMapping(value = "/{id}", produces={"application/json", "application/xml"})
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Defeito defeito = service.find(id);
		return ResponseEntity.ok(defeito);
	}

	@ApiOperation(value = "Retorna todos os defeitos persistidos.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "No Content")
	})
	@GetMapping(produces={"application/json", "application/xml"})
	public ResponseEntity<?> findAll() {
		List<Defeito> defeitos = service.findAll();
		
		return (defeitos.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(defeitos);
	}

	@ApiOperation(value = "Persiste o defeito enviado no corpo da requisição.")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request. O objeto enviado no corpo da requisição é inválido.")
	})
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(consumes={"application/json", "application/xml"})
	public ResponseEntity<?> insert(@Valid @RequestBody Defeito defeitoArg) {
		Defeito defeito = service.insert(defeitoArg);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(defeito.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Remove o defeito correspondente ao parâmetro.")
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "No Content"),
			@ApiResponse(code = 400, message = "Bad Request. O parâmetro enviado não corresponde a nenhum objeto no servidor.")
	})
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleConstraintViolation(EmptyResultDataAccessException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionMessages.getEmptyResultDataAccessExceptionMsg(ex));
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleConstraintViolation(IllegalArgumentException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionMessages.getIllegalArgumentExceptionMsg(ex));
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<?> handleConstraintViolation(InvalidFormatException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						"A data inserida está em um formato inválido. Certifique-se de formatá-la no modelo 'dd-MM-aaaa'." + 
					    "\n" + "Erro: '" + ex.toString() + "'.");
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<?> handleConstraintViolation(ObjectNotFoundException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionMessages.getObjectNotFoundExceptionMsg(ex));
	}
}
