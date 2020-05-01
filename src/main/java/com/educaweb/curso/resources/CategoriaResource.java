package com.educaweb.curso.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaweb.curso.domain.Categoria;
import com.educaweb.curso.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {		
		Categoria obj = service.buscar(id);		
		return ResponseEntity.ok().body(obj);
	}
}