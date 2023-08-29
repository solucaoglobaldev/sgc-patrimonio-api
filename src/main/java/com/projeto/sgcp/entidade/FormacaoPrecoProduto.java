package com.projeto.sgcp.entidade;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name="tbformacaoprecoproduto")
public class FormacaoPrecoProduto {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;	

	private LocalDate dtCadastro;		
	
	private BigDecimal valorCompra;
	
	private BigDecimal valorCusto;
	
	private BigDecimal valorVenda;
	
	private BigDecimal lucroObtido;
	
	private Double margemLucro;
	
	@ManyToOne
	private CadastroProduto codigoProduto;
	

}
