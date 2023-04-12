package com.projeto.sgcp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class DepartamentoDTO {

	private Long codigoDepartamento;

	private String nmDepartamento;
}
