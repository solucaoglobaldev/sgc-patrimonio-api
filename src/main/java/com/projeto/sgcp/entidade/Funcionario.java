package com.projeto.sgcp.entidade;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbfuncioario")
public class Funcionario {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@javax.persistence.Id
	private Long matriculaFuncionario;
	
	private String nomeFuncionario;
	
	private LocalDate dataCadastro;
	
	private String cpf;
	
	private String email;
	
	private String telefoneFixo;
	
	private String telefoneCelular;
	
	@Embedded
	private Endereco endereco;

}
