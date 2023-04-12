package com.projeto.sgcp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.sgcp.entidade.Departamento;
import com.projeto.sgcp.enuns.Status;
import com.projeto.sgcp.repositorio.DepartamentoRepositorio;
import com.projeto.sgcp.utilitarios.Utils;

@Service
public class ServiceDepartamento {

	@Autowired
	private DepartamentoRepositorio depRepositorio;

	@Autowired
	private Utils utils;
	
	@Transactional
	public Departamento SalvarDadosDepartamento(Departamento departamento) {

		departamento.setStatusDepartamento(Status.ATIVO);

		utils.ValidarCamposDepartamento(departamento);
		
		utils.validaStringDepartamento(departamento.getNomeDepartamento());

		BuscarDepartamento(departamento.getNomeDepartamento());

		return depRepositorio.save(departamento);
	}

	@Transactional
	public Departamento RemoverDepartamento(Departamento departamento) {

		departamento.setStatusDepartamento(Status.INATIVO);
		return depRepositorio.save(departamento);

	}

	@Transactional
	public Departamento AutualizarDadosDepartamento(Departamento departamento, String nome) {

		Objects.requireNonNull(departamento.getCodigoDepartamento());

		utils.ValidarCamposDepartamento(departamento);

		utils.validaStringDepartamento(nome);

		return depRepositorio.save(departamento);

	}

	@Transactional(readOnly = true)
	public List<Departamento> ListarDepartamento() {
		return depRepositorio.findAll();
	}

	

	@Transactional
	public Departamento BuscarDepartamento(String departamento) {
		return depRepositorio.findBynomeDepartamento(departamento);
	}

	@Transactional
	public Departamento BuscarPorCodigo(Long codigoDep) {
		return depRepositorio.findBycodigoDepartamento(codigoDep);
	}
}

	
