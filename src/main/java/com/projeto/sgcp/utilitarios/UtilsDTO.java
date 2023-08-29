package com.projeto.sgcp.utilitarios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projeto.sgcp.dto.ServicoDTO;
import com.projeto.sgcp.dto.GrupoDTO;
import com.projeto.sgcp.entidade.Servico;
import com.projeto.sgcp.entidade.Grupo;

@Service
public class UtilsDTO {
	
	public ServicoDTO toDepartamento(Servico depEncontrado) {
		
		ServicoDTO servDTO = new ServicoDTO();		

		servDTO.setCodigoServico(depEncontrado.getCodigoServico());
		
		servDTO.setNmServico(depEncontrado.getNomeServico());
		
		return servDTO;
	}
	
	public List<ServicoDTO> toCollecitonDTO(List<Servico> departamentos){
		
		return departamentos.stream()
				.map(departamento -> toDepartamento(departamento))
				.collect(Collectors.toList());
		
	}
	
	
	public GrupoDTO toGrupo (Grupo grupEncontrado) {
		
		GrupoDTO grupDTO = new GrupoDTO();		
		
		grupDTO.setCodGrupo(grupEncontrado.getCodigoGrupo());
		
		grupDTO.setNmGrupo(grupEncontrado.getNomeGrupo());
		
		return grupDTO;
	}
	
	public List<GrupoDTO> grupCollecitonDTO(List<Grupo> grupos){
		
		return grupos.stream()
				.map(grupo -> toGrupo(grupo))
				.collect(Collectors.toList());
		
	}

}
