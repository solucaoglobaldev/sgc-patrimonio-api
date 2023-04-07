package com.projeto.sgcp.utilitarios;

import java.util.List;
import java.util.stream.Collectors;

import com.projeto.sgcp.dto.DepartamentoDTO;
import com.projeto.sgcp.dto.GrupoDTO;
import com.projeto.sgcp.entidade.Departamento;
import com.projeto.sgcp.entidade.Grupo;

public class UtilsDTO {
	
	public DepartamentoDTO toDepartamento(Departamento depEncontrado) {
		
		DepartamentoDTO depDTO = new DepartamentoDTO();		

		depDTO.setCodigoDepartamento(depEncontrado.getCodigoDepartamento());
		
		depDTO.setNmDepartamento(depEncontrado.getNmDepartamento());
		
		return depDTO;
	}
	
	public List<DepartamentoDTO> toCollecitonDTO(List<Departamento> departamentos){
		
		return departamentos.stream()
				.map(departamento -> toDepartamento(departamento))
				.collect(Collectors.toList());
		
	}
	
	
	public GrupoDTO toGrupo (Grupo grupEncontrado) {
		
		GrupoDTO grupDTO = new GrupoDTO();		
		
		grupDTO.setCodGrupo(grupEncontrado.getCodGrupo());
		
		grupDTO.setNmGrupo(grupEncontrado.getNmGrupo());
		
		return grupDTO;
	}
	
	public List<GrupoDTO> grupCollecitonDTO(List<Grupo> grupos){
		
		return grupos.stream()
				.map(grupo -> toGrupo(grupo))
				.collect(Collectors.toList());
		
	}

}
