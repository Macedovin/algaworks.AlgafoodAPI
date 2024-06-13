package com.macedovingithub.algafoodAPI.domain.repository;

import java.util.List;

import com.macedovingithub.algafoodAPI.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> listar();
	Cozinha buscar(Long id);
//	-> MÉTODO EXTRA feito para estudo...
	List<Cozinha> buscarNome(String nome);
	Cozinha salvar(Cozinha cozinha);
	void remover(Cozinha cozinha);
	
/*
 * -> Exemplos de sintaxe com COLLECTION-ORIENTED REPOSITORY
	List<Cozinha> todos();
	Cozinha porId(Long id);
//	-> MÉTODO EXTRA feito para estudo...
	List<Cozinha> porNome(String nome);
	Cozinha adicionar(Cozinha cozinha);
	void remover(Cozinha cozinha);
	*/
}
