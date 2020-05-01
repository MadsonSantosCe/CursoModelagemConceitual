package com.educaweb.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaweb.curso.domain.Categoria;
import com.educaweb.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository reposity;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = reposity.findById(id);
		return obj.orElse(null);
	}
}
