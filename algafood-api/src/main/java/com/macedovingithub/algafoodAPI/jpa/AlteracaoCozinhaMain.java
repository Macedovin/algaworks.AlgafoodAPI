package com.macedovingithub.algafoodAPI.jpa;

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
public class AlteracaoCozinhaMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
//		-> Chamo o método adicionar() que, por sua vez, chama o método merge()
//			- Passando um ID já existente no Banco de Dados
		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);
		cozinha.setNome("Brasileira");
		
//		cozinha = cadastroCozinha.adicionar(cozinha);
		
//		-> Refatorando o nome do antigo MÉTODO adicionar()
		cozinha = cadastroCozinha.salvar(cozinha);
	}
}
