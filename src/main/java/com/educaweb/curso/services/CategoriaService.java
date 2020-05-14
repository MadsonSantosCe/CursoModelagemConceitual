package com.educaweb.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaweb.curso.domain.Categoria;
import com.educaweb.curso.exception.ObjectNotFoundException;
import com.educaweb.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository reposity;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = reposity.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return reposity.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return reposity.save(obj);
	}
}
