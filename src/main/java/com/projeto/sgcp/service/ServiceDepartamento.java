package com.projeto.sgcp.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.sgcp.Exception.RegraNegocio;
import com.projeto.sgcp.entidade.Departamento;
import com.projeto.sgcp.enuns.Status;
import com.projeto.sgcp.repositorio.DepartamentoRepositorio;

@Service
public class ServiceDepartamento {

	@Autowired
	private DepartamentoRepositorio depRepositorio;

	@Transactional
	public Departamento salvarDadosDepartamento(Departamento departamento) {

		departamento.setStatusDep(Status.ATIVO);

		validarCamposDepartamento(departamento);
		
		validaStringDepartamento(departamento.getNmDepartamento());

		buscarDepartamento(departamento.getNmDepartamento());

		return depRepositorio.save(departamento);
	}

	@Transactional
	public Departamento removerDepartamento(Departamento departamento) {

		departamento.setStatusDep(Status.INATIVO);
		return depRepositorio.save(departamento);

	}

	@Transactional
	public Departamento autualizarDadosDepartamento(Departamento departamento, String nome) {

		Objects.requireNonNull(departamento.getCodigoDepartamento());

		validarCamposDepartamento(departamento);

		validaStringDepartamento(nome);

		return depRepositorio.save(departamento);

	}

	@Transactional(readOnly = true)
	public List<Departamento> listarDepartamento() {
		return depRepositorio.findAll();
	}

	public void validarCamposDepartamento(Departamento departamento) {

		if (departamento.getNmDepartamento() == null || departamento.getNmDepartamento().trim().equals("")) {

			throw new RegraNegocio("O nome departamento é obrigatório");
		}

	}

	@Transactional
	public Departamento buscarDepartamento(String departamento) {
		return depRepositorio.findByNmDepartamento(departamento);
	}

	@Transactional
	public Departamento buscarPorCodigo(Long codigoDep) {
		return depRepositorio.findBycodigoDepartamento(codigoDep);
	}

	public void validaStringDepartamento(String departamento) {
		
		if (!departamento.matches("[A-Za-z]*")) {
			
			//(!departamento.substring(0, 15).matches("[A-Za-z]*"))

			throw new RegraNegocio("Erro ao cadastrar, nome do departamento não pode constar numeros ou caracteres");
		}
	}
}
