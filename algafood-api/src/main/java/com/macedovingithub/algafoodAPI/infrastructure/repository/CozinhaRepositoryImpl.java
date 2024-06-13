package com.macedovingithub.algafoodAPI.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.macedovingithub.algafoodAPI.domain.model.Cozinha;
import com.macedovingithub.algafoodAPI.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository{

//	AQUI VÃO SER IMPLEMENTADOS OS MESMOS MÉTODOS ANTERIORMENTE IMPLEMENTADOS
//	-> Métodos existentes na CLASSE "CadastroCozinha" do PACOTE "jpa" da aplicação
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> listar() {
				
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		
		return query.getResultList();
		
//	-> Em uma estruta mais reduzida
/*
 	* 	return manager.createQuery("from Cozinha", Cozinha.class) 
 	* 		.getResultList(); 
 */
	} 
	
//	-> Busca um OBJETO do TIPO "Cozinha" pelo ID
	@Override
	public Cozinha buscar(Long id) {
		
		return manager.find(Cozinha.class, id);
	}

// 	-> MÉTODO EXTRA feito anteriormente para estudo	
// 	Busca OBJETOS do TIPO "Cozinha" pelo ATRIBUTO "nome" (que não o ID) //
//	 	- Uma das formas de se fazer isso 	
	@Override
	public List<Cozinha> buscarNome(String nome) {
	 
		TypedQuery<Cozinha> cozinhaNomeQuery = manager
			.createQuery("select c from Cozinha c where c.nome = :nome", Cozinha.class)
			.setParameter("nome", nome);
	 
		return cozinhaNomeQuery.getResultList(); 
	}
	
//	O MÉTODO agora ADICIONA e ATUALIZA/ FAZ UPDATE de OBJETOS/ REGISTROS no Bnaco de Dados
	@Transactional
	@Override
	public Cozinha salvar(Cozinha cozinha) {
				
		return manager.merge(cozinha);
	}
	
	@Transactional
	@Override
	public void remover(Cozinha cozinha) {

//		-> Tornando o OBJETO gerenciado pelo CONTEXTO DE PERSISTÊNCIA 			
		cozinha = buscar(cozinha.getId());
		
		manager.remove(cozinha);
	}

}
