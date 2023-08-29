package com.projeto.sgcp.entidade;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbfornecedor")
public class Fornecedor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(unique = true)
	private String cnpj;
	
	private String razaoSocial;
	
	private String nomeFantasia;
	
	private LocalDate dtCadastro;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Embedded
	private Endereco endereco;

}
