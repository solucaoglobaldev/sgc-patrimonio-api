package com.projeto.sgcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.sgcp.Exception.RegraNegocio;
import com.projeto.sgcp.dto.GrupoDTO;
import com.projeto.sgcp.entidade.Grupo;
import com.projeto.sgcp.repositorio.GrupoRepositorio;
import com.projeto.sgcp.service.ServiceGrupo;
import com.projeto.sgcp.utilitarios.UtilsDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("api/grupos")
@RestController
@Api(value="API REST Grupos")
@CrossOrigin(origins="*")

public class ControllerGrupo {

	@Autowired
	private ServiceGrupo servicoGrupo;

	@Autowired
	private GrupoRepositorio grupoRepositorio;

	@Autowired
	private UtilsDTO utilsDTO;
	
	@PostMapping("adicionar")
	@ApiOperation(value="Adicionar Grupos")
	public ResponseEntity adicionar(@RequestBody GrupoDTO dtoGrupo) {

		Grupo grupo = Grupo.builder().nomeGrupo(dtoGrupo.getNmGrupo()).build();

		try {

			Grupo grupoEcontrado = servicoGrupo.BuscarPeloNome(grupo.getNomeGrupo());

			if (grupoEcontrado != null) {
				return ResponseEntity.badRequest().body("Grupo já cadastrado");
			}

			Grupo grupoSalvo = servicoGrupo.SalvarDadosGrupo(grupoEcontrado);

			return ResponseEntity.ok(grupoSalvo);

		} catch (RegraNegocio e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@GetMapping("remover/{codigoGrupo}")
	public ResponseEntity remover(@PathVariable Long codigoGrupo) {

		Grupo grupoEncontrado = servicoGrupo.BuscarGrupoPorCodigo(codigoGrupo);

		if (grupoEncontrado == null) {
			throw new RegraNegocio("Codigo informado não encontrado");
		}

		Grupo excluido = servicoGrupo.RemoverGrupo(grupoEncontrado);

		return ResponseEntity.ok(excluido);

	}

	@GetMapping("listar")
	public List<GrupoDTO> listar() {
		return utilsDTO.grupCollecitonDTO(servicoGrupo.ListarGrupo());

	}

	@PutMapping("/atualizarGrupo")
	public ResponseEntity atualizarGrupo(@PathVariable Long codigoGrupo, @RequestBody Grupo grupo) {

		Grupo grupoAtual = servicoGrupo.BuscarGrupoPorCodigo(codigoGrupo);

		if (grupoAtual == null) {
			return ResponseEntity.badRequest().body("Grupo não encontrado");
		}

		grupoAtual.setNomeGrupo(grupo.getNomeGrupo());

		grupoRepositorio.save(grupoAtual);

		return ResponseEntity.ok(grupoAtual);
	}
	
	@GetMapping("buscarPorCodito/{codigoGrupo}")
	public GrupoDTO buscarPorCodito (@PathVariable Long codigoGrupo) {
		
		Grupo grupoEncontrado = servicoGrupo.BuscarGrupoPorCodigo(codigoGrupo);
		
		if (grupoEncontrado == null) {
			throw new RegraNegocio("Codigo informado não encontrado");
		}
		
		return utilsDTO.toGrupo(grupoEncontrado);
	}

}
