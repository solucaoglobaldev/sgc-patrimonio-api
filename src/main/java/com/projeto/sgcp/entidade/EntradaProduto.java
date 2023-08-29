package com.projeto.sgcp.entidade;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "tbentradaestoque")

public class EntradaProduto {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private Long qtdEntradaEstoque;
	
	private LocalDateTime dtEntrada;

	@ManyToOne
	@JoinColumn(name = "codigo_produto")										
	private CadastroProduto produto;
}
