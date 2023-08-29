package com.projeto.sgcp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.sgcp.entidade.Servico;
import com.projeto.sgcp.enuns.Status;
import com.projeto.sgcp.repositorio.ServicoRepositorio;
import com.projeto.sgcp.utilitarios.Utils;

@Service
public class ServiceServico {

	@Autowired
	private ServicoRepositorio servRepositorio;

	@Autowired
	private Utils utils;
	
	@Transactional
	public Servico SalvarDadosServico(Servico servico) {

		servico.setStatusDepartamento(Status.ATIVO);

		utils.ValidarCamposDepartamento(servico);
		
		//utils.validaStringDepartamento(departamento.getNomeDepartamento());

		BuscarServico(servico.getNomeServico());

		return servRepositorio.save(servico);
	}

	@Transactional
	public Servico RemoverServico(Servico departamento) {

		departamento.setStatusDepartamento(Status.INATIVO);
		return servRepositorio.save(departamento);

	}
	
	@Transactional
	public Servico AtivarServico(Servico servico) {
		servico.setStatusDepartamento(Status.ATIVO);
		return servRepositorio.save(servico);
		
	}

	@Transactional
	public Servico AutualizarDadosServico(Servico servico) {

		Objects.requireNonNull(servico.getCodigoServico());

		utils.ValidarCamposDepartamento(servico);

	//	utils.validaStringDepartamento(nome);

		return servRepositorio.save(servico);

	}

	@Transactional(readOnly = true)
	public List<Servico> ListarServico() {
		return servRepositorio.findAll();
	}

	

	@Transactional
	public Servico BuscarServico(String departamento) {
		return servRepositorio.findBynomeServico(departamento);
	}

	@Transactional
	public Servico BuscarPorCodigo(Long codigoDep) {
		return servRepositorio.findBycodigoServico(codigoDep);
	}
}

	
