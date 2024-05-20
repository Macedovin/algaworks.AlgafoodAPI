package com.macedovingithub.algafoodAPI.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	
//	-> Busca um OBJETO do TIPO "Cozinha" pelo ID
	public Cozinha buscar(Long id) {
		
		return manager.find(Cozinha.class, id);
	}

//	-> Busca OBJETOS do TIPO "Cozinha" pelo ATRIBUTO "nome" (que não o ID)
//		- Uma das formas de se fazer isso
	public List<Cozinha> buscarNome(String nome) {
		
		TypedQuery<Cozinha> cozinhaNomeQuery = manager
				.createQuery("select c from Cozinha c where c.nome = :nome", Cozinha.class)
				.setParameter("nome", nome);
	
		return cozinhaNomeQuery.getResultList();
	}
	
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
				
		return manager.merge(cozinha);
	}
	
}
