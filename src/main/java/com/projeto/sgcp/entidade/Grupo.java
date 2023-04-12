package com.projeto.sgcp.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

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
@javax.persistence.Table(name = "tbgrupo")
public class Grupo {
	
	@Id
	private Long codigoGrupo;	
	
	private String nomeGrupo;
	
	@Enumerated(EnumType.ORDINAL)
	private Status statusGrupo;

}
