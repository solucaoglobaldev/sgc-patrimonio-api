package com.projeto.sgcp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sgcp.entidade.Vacina;

public interface VacinaRepositorio extends JpaRepository<Vacina, Long> {
	
	Vacina findBynomeVacina(String vacina);
	
	Vacina findBycodigoVacina(String codVacina);

}
