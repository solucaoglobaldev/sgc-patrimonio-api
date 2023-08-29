package com.projeto.sgcp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class VacinaDTO {
	
	private String codigoVacina;

	private String nomeVacina;
	
	private String statusVacina;

}
