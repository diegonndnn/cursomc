package com.diego.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.cursomc.domain.Cliente;
import com.diego.cursomc.repositories.ClienteRepository;
import com.diego.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	
	//Metodo ajustado conforme atualizacao para Spring Boot 2)
	public Cliente buscar(Integer id) {
		/**Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null); */
				
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id + ", Tipo: " + Cliente.class.getName()));
		
		
	}
	
}
