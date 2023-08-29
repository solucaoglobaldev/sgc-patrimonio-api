package com.projeto.sgcp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class ServicoDTO {

	private Long codigoServico;

	private String nmServico;
	
	private String statusServico;
}
