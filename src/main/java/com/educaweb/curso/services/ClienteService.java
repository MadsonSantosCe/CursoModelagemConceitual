package com.educaweb.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaweb.curso.domain.Cliente;
import com.educaweb.curso.exception.ObjectNotFoundException;
import com.educaweb.curso.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
