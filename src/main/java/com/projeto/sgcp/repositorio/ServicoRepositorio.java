package com.projeto.sgcp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sgcp.entidade.Servico;

public interface ServicoRepositorio extends JpaRepository<Servico, Long> {
	
	Servico findBynomeServico(String nomeServico);
	
	boolean existsBycodigoServico (Long codServico);
	
	Servico findBycodigoServico(Long codServico);
	
	
}
