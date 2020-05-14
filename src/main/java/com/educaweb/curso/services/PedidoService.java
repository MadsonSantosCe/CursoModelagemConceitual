package com.educaweb.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaweb.curso.domain.Pedido;
import com.educaweb.curso.exception.ObjectNotFoundException;
import com.educaweb.curso.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id + ", Tipo: "+ Pedido.class.getName()));
	}
}
