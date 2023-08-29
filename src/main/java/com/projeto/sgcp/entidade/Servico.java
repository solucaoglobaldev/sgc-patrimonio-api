package com.projeto.sgcp.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projeto.sgcp.enuns.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbservico")
public class Servico {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoServico;	
	
	private String nomeServico;
	
	@Enumerated(EnumType.STRING)
	private Status statusDepartamento;


}
