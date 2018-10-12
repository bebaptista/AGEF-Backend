package com.tisv.agef.resources;

import com.tisv.agef.domain.Modelo;
import com.tisv.agef.resources.helpers.ExceptionMessages;
import com.tisv.agef.services.ModeloService;
import com.tisv.agef.services.exceptions.ObjectNotFoundException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/modelos")
public class ModeloResource {

    private final ModeloService service;

    @Autowired
    public ModeloResource(ModeloService service) {
        this.service = service;
    }

    @ApiOperation(value = "Retorna o modelo correspondente ao parâmetro")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found. O objeto solicitado não foi encontrado no servidor.")
    })
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Modelo modelo = service.find(id);
        return ResponseEntity.ok(modelo);
    }

    @ApiOperation(value = "Retorna todos os modelos persistidos.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "No Content")
    })
    @GetMapping(produces = {"application/json", "application/xml"})
    public ResponseEntity<?> findAll() {
        List<Modelo> modelos = service.findAll();

        return (modelos.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(modelos);
    }

    @ApiOperation(value = "Persiste o modelo enviado no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request. O objeto enviado no corpo da requisição é inválido.")
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = {"application/json", "application/xml"})
    public ResponseEntity<?> insert(@Valid @RequestBody Modelo modeloArg) {
        Modelo modelo = service.insert(modeloArg);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(modelo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Remove o modelo correspondente ao parâmetro.")
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

    @ApiOperation(value = "Atualiza o modelo enviado no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 400, message = "Bad Request. O objeto enviado no corpo da requisição é inválido.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", consumes = {"application/json", "application/xml"})
    public ResponseEntity<?> update(@Valid @RequestBody Modelo modelo, @PathVariable Integer id) {
        service.update(id, modelo);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionMessages.getConstraintViolationExceptionMsg(ex));
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
