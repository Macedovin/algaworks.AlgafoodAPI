package com.macedovingithub.algafoodAPI.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurante {
	
	@Id
	private Long id;
	
	private String nome;
	
	@Column(name = "taa_frete")
	private BigDecimal taxaFrete;
}