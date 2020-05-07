package com.educaweb.curso.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaweb.curso.domain.Pedido;
import com.educaweb.curso.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
