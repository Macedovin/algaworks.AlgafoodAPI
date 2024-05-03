package com.macedovingithub.algafoodAPI.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.macedovingithub.algafoodAPI.domain.model.Cozinha;

@Component
public class CadastroCozinha {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Cozinha> listar() {
				
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		
		return query.getResultList();

		
//		-> Numa estruta mais reduzida
/*
 	* 	return manager.createQuery("from Cozinha", Cozinha.class) 
 	* 		.getResultList(); 
 */
	} 
}