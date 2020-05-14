package com.educaweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educaweb.curso.domain.Categoria;
import com.educaweb.curso.exception.DataIntegrityException;
import com.educaweb.curso.exception.ObjectNotFoundException;
import com.educaweb.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository reposity;
	
	public List<Categoria> findAll(){
		return reposity.findAll();
	}
	
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
	
	public void delete(Integer id) {
		find(id);
		try {
			reposity.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
		
	}	
	
}
