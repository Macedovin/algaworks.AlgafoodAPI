package com.macedovingithub.algafoodAPI.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.macedovingithub.algafoodAPI.AlgafoodApiApplication;
import com.macedovingithub.algafoodAPI.domain.model.Cozinha;
import com.macedovingithub.algafoodAPI.domain.repository.CozinhaRepository;

/*
 * Classe criada para que executar os testes de integração com o banco de dados sem a necessidade de subir
 *  o servidor web
 */

@SpringBootApplication
public class ExclusaoCozinhaMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

	/*
	 * 	 -> Exemplo de sintaxe com COLLECTION-ORIENTED REPOSITORY 
	 * 		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
	 * 
	 *  	cozinhas.remover(cozinha);
	 */	
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);

		cozinhaRepository.remover(cozinha);
	}
}
