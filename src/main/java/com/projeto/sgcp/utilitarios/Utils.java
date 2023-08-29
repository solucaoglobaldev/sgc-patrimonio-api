package com.projeto.sgcp.utilitarios;

import org.springframework.stereotype.Service;

import com.projeto.sgcp.entidade.Servico;
import com.projeto.sgcp.exception.RegraNegocio;
import com.projeto.sgcp.entidade.Grupo;


@Service
public class Utils {
	
	public void ValidaNomeGrupo(Grupo nomeGrupo) {

		if (!nomeGrupo.getNomeGrupo().toString().matches("[A-Za-z]*")) {

			throw new RegraNegocio("Erro ao cadastrar, nome do grupo não pode constar numeros ou caracteres");
		}

	}

	public void ValidaCamposGrupo(Grupo grupoNome) {

		if (grupoNome.getNomeGrupo() == null || grupoNome.getNomeGrupo().strip().equals("")) {
			throw new RegraNegocio("O nome grupo é obrigatório");
		}
	}
	
	public void ValidarCamposDepartamento(Servico departamento) {

		if (departamento.getNomeServico() == null || departamento.getNomeServico().trim().equals("")) {

			throw new RegraNegocio("O nome departamento é obrigatório");
		}

	}
	
	public void validaStringDepartamento(String departamento) {
		
		if (!departamento.matches("[A-Za-z]*")) {
			
			//(!departamento.substring(0, 15).matches("[A-Za-z]*"))

			throw new RegraNegocio("Erro ao cadastrar, nome do departamento não pode constar numeros ou caracteres");
		}
	}
}


