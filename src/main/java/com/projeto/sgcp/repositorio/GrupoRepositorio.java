package com.projeto.sgcp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sgcp.entidade.Grupo;

public interface GrupoRepositorio extends JpaRepository<Grupo, Long> {
	
	Grupo findBycodGrupo(Long codigoGrupo);
	
	Grupo findBynmGrupo(String nmGrupo);
	
	boolean existsBycodGrupo(Long codGrupo);

}




