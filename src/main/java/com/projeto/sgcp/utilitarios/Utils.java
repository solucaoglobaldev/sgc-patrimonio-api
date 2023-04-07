package com.projeto.sgcp.utilitarios;

import com.projeto.sgcp.Exception.RegraNegocio;
import com.projeto.sgcp.entidade.Departamento;
import com.projeto.sgcp.entidade.Grupo;

public class Utils {
	
	public void ValidaNomeGrupo(Grupo nomeGrupo) {

		if (!nomeGrupo.getNmGrupo().toString().matches("[A-Za-z]*")) {

			throw new RegraNegocio("Erro ao cadastrar, nome do grupo não pode constar numeros ou caracteres");
		}

	}

	public void ValidaCamposGrupo(Grupo grupoNome) {

		if (grupoNome.getNmGrupo() == null || grupoNome.getNmGrupo().strip().equals("")) {
			throw new RegraNegocio("O nome grupo é obrigatório");
		}
	}
	
	public void ValidarCamposDepartamento(Departamento departamento) {

		if (departamento.getNmDepartamento() == null || departamento.getNmDepartamento().trim().equals("")) {

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


