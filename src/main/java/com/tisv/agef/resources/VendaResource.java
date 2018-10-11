package com.tisv.agef.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.tisv.agef.domain.Venda;
import com.tisv.agef.resources.helpers.ExceptionMessages;
import com.tisv.agef.services.VendaService;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {

	@Autowired
	private VendaService service;

	@ApiOperation(value = "Retorna a venda correspondente ao parâmetro.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 404, message = "Not Found. O objeto solicitado não foi encontrado no servidor.")
	})
	@GetMapping(value = "/{id}", produces={"application/json", "application/xml"})
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Venda venda = service.find(id);
		return ResponseEntity.ok(venda);
	}

	@ApiOperation(value = "Retorna todas as vendas persistidas.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "No Content")
	})
	@GetMapping(produces={"application/json", "application/xml"})
	public ResponseEntity<?> findAll() {
		List<Venda> vendas = service.findAll();

		return (vendas.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(vendas);
	}

	@ApiOperation(value = "Retorna os dados do faturamento do período correspondente ao parâmetro.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 204, message = "No Content"),
			@ApiResponse(code = 400, message = "Bad Request. A data inicial deve ser menor do que a data final e ambas devem ser iguais ou menores do que a data atual e seguir o modelo 'dd-MM-aaaa'.")
	})
	@GetMapping(value = "/faturamento", produces={"application/json", "application/xml"})
	public ResponseEntity<?> calculaFaturamento(
			@RequestParam(value = "dataInicial") @DateTimeFormat(pattern = ("dd-MM-yyyy")) LocalDate dataInicial,
			@RequestParam(value = "dataFinal") @DateTimeFormat(pattern = ("dd-MM-yyyy")) LocalDate dataFinal) {
		Double faturamento = service.calcularFaturamento(dataInicial, dataFinal);

		return (faturamento == null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(faturamento);

	}

	@ApiOperation(value = "Persiste a venda enviada no corpo da requisição.")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request. O objeto enviado no corpo da requisição é inválido.")
	})
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody Venda vendaArg) {
		Venda venda = service.insert(vendaArg);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venda.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Remove a venda correspondente ao parâmetro.")
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

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<?> handleConstraintViolation(InvalidFormatException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						"A data inserida está em um formato inválido. Certifique-se de formatá-la no modelo 'dd-MM-aaaa'." + 
					    "\n" + "Erro: '" + ex.toString() + "'.");
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleConstraintViolation(EmptyResultDataAccessException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionMessages.getEmptyResultDataAccessExceptionMsg(ex));
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<?> handleConstraintViolation(ObjectNotFoundException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionMessages.getObjectNotFoundExceptionMsg(ex));
	}
}
