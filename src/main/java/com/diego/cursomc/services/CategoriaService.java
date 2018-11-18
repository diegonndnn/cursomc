package com.diego.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.cursomc.domain.Categoria;
import com.diego.cursomc.repositories.CategoriaRepository;
import com.diego.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	//Metodo ajustado conforme atualizacao para Spring Boot 2)
	public Categoria buscar(Integer id) {
		/**Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null); */
				
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id + ", Tipo: " + Categoria.class.getName()));
		
		
	}
	
}
