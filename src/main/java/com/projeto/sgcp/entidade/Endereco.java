package com.projeto.sgcp.entidade;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class Endereco {
	
	@Column(name ="endereco_cep")
	private String cep;
	
	@Column(name ="endereco_logadouro")
	private String logadouro;
	
	@Column(name ="endereco_numero")
	private String numero;
	
	@Column(name ="endereco_bairro")
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name ="endereco_cidade_id")
	private Cidade cidade;
	

}
