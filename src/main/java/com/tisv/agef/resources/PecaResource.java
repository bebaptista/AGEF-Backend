package com.tisv.agef.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tisv.agef.domain.Peca;
import com.tisv.agef.services.PecaService;

@RestController
@RequestMapping(value="/pecas")
public class PecaResource {
	
	@Autowired
	private PecaService service;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Peca> obj = service.findAll();
		
		return ResponseEntity.ok(obj);
	}
}
