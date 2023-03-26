package com.projeto.sgcp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RequestMapping("/departamentos")
@RestController
public class ControllerDepartamento {

	@Autowired
	private ServiceDepartamento servicoDepartametno;

	@Autowired
	private DepartamentoRepositorio depRepositorio;

	@PostMapping("adicionar")
	public ResponseEntity adicionar(@RequestBody DepartamentoDTO DTOdepartamento) {

		Departamento departamento = Departamento.builder().nmDepartamento(DTOdepartamento.getNmDepartamento()).build();

		try {

			Departamento departamentoEcontrado = servicoDepartametno
					.buscarDepartamento(departamento.getNmDepartamento());

			if (departamentoEcontrado != null) {
				return ResponseEntity.badRequest().body("Departameto já cadastrado");
			}

			Departamento depSalvo = servicoDepartametno.salvarDadosDepartamento(departamento);

			// return new ResponseEntity(depSalvo, HttpStatus.CREATED);

			return ResponseEntity.ok(depSalvo);

		} catch (RegraNegocio e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PutMapping("atulizarDepartamento/{codigoDp}")
	public ResponseEntity atulizarDepartamento(@PathVariable Long codigoDp,
			@RequestBody Departamento departamento) {

		Departamento depAtual = servicoDepartametno.buscarPorCodigo(codigoDp);

		if (depAtual == null) {
			return ResponseEntity.badRequest().body("Departameto não encontrado");
		}

			depAtual.setNmDepartamento(departamento.getNmDepartamento()); 

		//BeanUtils.copyProperties(departamento, depAtual, "id");

		depRepositorio.save(depAtual);

		return ResponseEntity.ok(depAtual);
	}

	@GetMapping("buscarPorCodigo/{codigo}")
	public Departamento buscarPorCodigo(@PathVariable Long codigo) {
		return servicoDepartametno.buscarPorCodigo(codigo);
	}

	@GetMapping("remover/{codigoDep}")
	public ResponseEntity remover(@PathVariable Long codigoDep) {

		Departamento depEncontrado = servicoDepartametno.buscarPorCodigo(codigoDep);

		if (depEncontrado == null) {
			return ResponseEntity.badRequest().body("Departamento não encontrado");
		}

		Departamento depExcluido = servicoDepartametno.removerDepartamento(depEncontrado);

		return ResponseEntity.ok(depExcluido);
	}

	@GetMapping("listar")
	public List<Departamento> listar() {
		return servicoDepartametno.listarDepartamento();
	}
}
