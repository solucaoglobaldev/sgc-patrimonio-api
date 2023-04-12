package com.projeto.sgcp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sgcp.entidade.Grupo;

public interface GrupoRepositorio extends JpaRepository<Grupo, Long> {
	
	Grupo findBycodigoGrupo(Long codigoGrupo);
	
	Grupo findBynomeGrupo(String nomeGrupo);
	
	boolean existsBycodigoGrupo(Long codigoGrupo);

}




