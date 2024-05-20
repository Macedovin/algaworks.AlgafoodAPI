package com.macedovingithub.algafoodAPI.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.macedovingithub.algafoodAPI.AlgafoodApiApplication;
import com.macedovingithub.algafoodAPI.domain.model.Cozinha;

/*
 * Classe criada para que executar os testes de integração com o banco de dados sem a necessidade de subir
 *  o servidor web
 */

@SpringBootApplication
public class BuscaCozinhaMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

//		-> Chama o método que executa a busca pelo ID
		Cozinha cozinha = cadastroCozinha.buscar(1L);
		
		System.out.println("Nome da Cozinha: " + cozinha.getNome());

//		-> Chama o método que executa a busca pelo ATRIBUTO "nome", referenciando o mesmo OBJETO
		List<Cozinha> cozinhaNomes = cadastroCozinha.buscarNome("Tailandesa");  
		
		for (Cozinha cozinhaN: cozinhaNomes) {
			
			System.out.println("Identificador (id) da cozinha: " + cozinhaN.getId());
		}
		
	}
}
