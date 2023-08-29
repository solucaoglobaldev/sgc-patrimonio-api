package com.projeto.sgcp.entidade;

import java.time.LocalDate;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbcadastroproduto")
public class CadastroProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoProduto;

	private LocalDate dtCadastro;
	
	private String descricaoProduto;
	
	@Enumerated(EnumType.STRING)
	private Status status;
}
