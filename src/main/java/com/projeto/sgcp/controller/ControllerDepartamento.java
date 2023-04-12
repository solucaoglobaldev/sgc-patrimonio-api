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
import com.projeto.sgcp.dto.DepartamentoDTO;
import com.projeto.sgcp.entidade.Departamento;
import com.projeto.sgcp.repositorio.DepartamentoRepositorio;
import com.projeto.sgcp.service.ServiceDepartamento;
import com.projeto.sgcp.utilitarios.UtilsDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("api/departamentos")
@RestController
@Api(value="API REST Departamento")
@CrossOrigin(origins="*")

public class ControllerDepartamento {

	@Autowired
	private ServiceDepartamento servicoDepartamento;

	@Autowired
	private DepartamentoRepositorio depRepositorio;

	@Autowired
	private UtilsDTO utilsDTO;
	
	@PostMapping("adicionar")	
	@ApiOperation(value="Adicionar Departamentos")
	public ResponseEntity adicionar(@RequestBody DepartamentoDTO DTOdepartamento) {

		Departamento departamento = Departamento.builder().nomeDepartamento(DTOdepartamento.getNmDepartamento()).build();

		try {

			Departamento departamentoEcontrado = servicoDepartamento
					.BuscarDepartamento(departamento.getNomeDepartamento());

			if (departamentoEcontrado != null) {
				return ResponseEntity.badRequest().body("Departameto já cadastrado");
			}

			Departamento depSalvo = servicoDepartamento.SalvarDadosDepartamento(departamento);

			// return new ResponseEntity(depSalvo, HttpStatus.CREATED);

			return ResponseEntity.ok(depSalvo);

		} catch (RegraNegocio e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PutMapping("atualizarDepartamento/{codigoDp}")
	@ApiOperation(value="Atualiza Departamentos")
	public ResponseEntity atualizarDepartamento(@PathVariable Long codigoDp, @RequestBody Departamento departamento) {

		Departamento depAtual = servicoDepartamento.BuscarPorCodigo(codigoDp);

		if (depAtual == null) {
			return ResponseEntity.badRequest().body("Departameto não encontrado");
		}

		depAtual.setNomeDepartamento(departamento.getNomeDepartamento());

		// BeanUtils.copyProperties(departamento, depAtual, "id");

		depRepositorio.save(depAtual);

		return ResponseEntity.ok(depAtual);
	}

	@GetMapping("buscarPorCodigo/{codigo}")
	@ApiOperation(value="Busca Departamentos por Codigo")
	public DepartamentoDTO buscarPorCodigo(@PathVariable Long codigo) {
		Departamento depEncontrado = servicoDepartamento.BuscarPorCodigo(codigo);

		// DepartamentoDTO depDTO = toDepartamento(depEncontrado);

		return utilsDTO.toDepartamento(depEncontrado);
	}

	@GetMapping("remover/{codigoDep}")
	@ApiOperation(value="Remove Departamentos")
	public ResponseEntity remover(@PathVariable Long codigoDep) {

		Departamento depEncontrado = servicoDepartamento.BuscarPorCodigo(codigoDep);

		if (depEncontrado == null) {
			return ResponseEntity.badRequest().body("Departamento não encontrado");
		}

		Departamento depExcluido = servicoDepartamento.RemoverDepartamento(depEncontrado);

		return ResponseEntity.ok(depExcluido);
	}

	@GetMapping("listar")	
	@ApiOperation(value="Lista os  Departamentos")
	public List<DepartamentoDTO> listar() {
		return utilsDTO.toCollecitonDTO(servicoDepartamento.ListarDepartamento());
	}

	

}
