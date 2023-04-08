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
@Table(name="tbdepartamento")
public class Departamento {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoDepartamento;
	
	
	private String nmDepartamento;
	
	@Enumerated(EnumType.STRING)
	private Status statusDep;


}
