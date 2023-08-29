package com.projeto.sgcp.entidade;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.projeto.sgcp.enuns.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbusuario")
public class Usuario {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@javax.persistence.Id
	private Long matriculaUsuario;
	
	private String nomeUsuario;
	
	private LocalDate dataCadastro;
	
	private String senhaUsuario;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	private String cpf;
	
	private String email;
		
	private String telefoneCelular;
	
	@Embedded
	private Endereco endereco;

}
