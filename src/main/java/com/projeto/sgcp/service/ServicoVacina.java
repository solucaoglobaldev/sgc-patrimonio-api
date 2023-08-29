package com.projeto.sgcp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.sgcp.entidade.Vacina;
import com.projeto.sgcp.enuns.Status;
import com.projeto.sgcp.repositorio.VacinaRepositorio;

@Service
public class ServicoVacina {
	
	@Autowired
	private VacinaRepositorio vacinaRepositorio;
	
	@Transactional
	public Vacina cadastrarVacina (Vacina vacina) {
		
		LocalDate dtCadastro = LocalDate.now();
		
		vacina.setDataCadastro(dtCadastro);
		
		vacina.setStatusVacina(Status.ATIVO);
		
		vacina.setSiglaVacina("VC");
		
		buscarVacina(vacina.getNomeVacina());
		
		return vacinaRepositorio.save(vacina);
		
	}
	
	@Transactional
	public Vacina  removerVacina(Vacina vacina) {
		
		vacina.setStatusVacina(Status.INATIVO);
		
		return vacinaRepositorio.save(vacina);
	}
	
	@Transactional
	public Vacina ativarVacina(Vacina vacina) {
		
		vacina.setStatusVacina(Status.ATIVO);
		
		return vacinaRepositorio.save(vacina);
	}
	
	@Transactional
	public Vacina buscarVacina(String vacina) {
		
		return vacinaRepositorio.findBynomeVacina(vacina);
	}
	
	@Transactional
	public Vacina atualizarVacina (Vacina vacina) {
		
		Objects.requireNonNull(vacina.getCodigoVacina());
		
		return vacinaRepositorio.save(vacina);
	}
	
	@Transactional(readOnly = true)
	public List<Vacina> listarVacina(){
		return vacinaRepositorio.findAll();
	}
	
	@Transactional
	public Vacina buscarPorCodigo (String codVacina) {
		
		return vacinaRepositorio.findBycodigoVacina(codVacina);
	}

}
