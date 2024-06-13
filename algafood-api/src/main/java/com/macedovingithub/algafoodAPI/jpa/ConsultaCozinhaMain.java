package com.macedovingithub.algafoodAPI.jpa;

import java.util.List;

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
public class ConsultaCozinhaMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

/*
 * 	 -> Exemplo de sintaxe com COLLECTION-ORIENTED REPOSITORY //
 * 		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
 * 
 *  	List<Cozinha> todasCozinhas = cozinhas.todas();
 */		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);


		List<Cozinha> todasCozinhas = cozinhaRepository.listar();
		
		for (Cozinha cozinha : todasCozinhas) {
			
			System.out.println(cozinha.getNome());
		}
	}
}
