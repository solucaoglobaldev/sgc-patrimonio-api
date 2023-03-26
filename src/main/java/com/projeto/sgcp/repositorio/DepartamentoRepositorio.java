package com.projeto.sgcp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sgcp.entidade.Departamento;

public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long> {
	
	Departamento findByNmDepartamento(String nmDepartamento);
	
	boolean existsBycodigoDepartamento (Long codDepartamento);
	
	Departamento findBycodigoDepartamento(Long codigoDep);
	
	
}
