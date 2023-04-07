package com.projeto.sgcp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.sgcp.entidade.Grupo;
import com.projeto.sgcp.enuns.Status;
import com.projeto.sgcp.repositorio.GrupoRepositorio;
import com.projeto.sgcp.utilitarios.Utils;

@Service
public class ServiceGrupo {

	@Autowired
	private GrupoRepositorio grupoRepositorio;

	@Autowired
	private Utils utils;

	@Transactional
	public Grupo SalvarDadosGrupo(Grupo grupo) {

		grupo.setStatusGrup(Status.ATIVO);

		utils.ValidaCamposGrupo(grupo);

		utils.ValidaNomeGrupo(grupo);

		BuscarPeloNome(grupo.getNmGrupo());

		return grupoRepositorio.save(grupo);

	}

	@Transactional
	public Grupo RemoverGrupo(Grupo grupo) {

		grupo.setStatusGrup(Status.INATIVO);

		return grupoRepositorio.save(grupo);

	}

	@Transactional
	public Grupo AtualizarGrupo(Grupo grupo) {

		Objects.requireNonNull(grupo.getCodGrupo());

		utils.ValidaNomeGrupo(grupo);

		utils.ValidaCamposGrupo(grupo);

		return grupoRepositorio.save(grupo);

	}

	@Transactional(readOnly = true)
	public List<Grupo> ListarGrupo() {
		return grupoRepositorio.findAll();
	}

	@Transactional
	public Grupo BuscarPeloNome(String nomeGrupo) {

		return grupoRepositorio.findBynmGrupo(nomeGrupo);
	}

	@Transactional
	public Grupo BuscarGrupoPorCodigo(Long codGrupo) {

		return grupoRepositorio.findBycodGrupo(codGrupo);
	}

}
