package com.projeto.sgcp.entidade;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.projeto.sgcp.enuns.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tbvacina")
public class Vacina {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Id
	private String codigoVacina;
	
	@PrePersist
	private void vacinaToUpperCase() {
		codigoVacina = codigoVacina.toUpperCase();
	}
	
	private String nomeVacina;
	
	private String siglaVacina;

	private LocalDate dataCadastro;

	@Enumerated(EnumType.STRING)
	private Status statusVacina;
	
}


