package com.projeto.sgcp.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sgcp.entidade.Grupo;

public interface GrupoRepositorio extends JpaRepository<Grupo, Long> {
	
	Optional<Grupo> findBycodGrupo(Long codigoGrupo);
	
	Optional<Grupo> findBynmGrupo(String nmGrupo);
	
	boolean existsBycodGrupo(Long codGrupo);

}




