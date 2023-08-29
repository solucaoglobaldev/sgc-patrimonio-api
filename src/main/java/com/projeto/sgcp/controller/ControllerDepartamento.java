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

import com.projeto.sgcp.dto.ServicoDTO;
import com.projeto.sgcp.entidade.Servico;
import com.projeto.sgcp.exception.RegraNegocio;
import com.projeto.sgcp.repositorio.ServicoRepositorio;
import com.projeto.sgcp.service.ServiceServico;
import com.projeto.sgcp.utilitarios.UtilsDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("api/servicos")
@RestController
public class ControllerDepartamento {

	@Autowired
	private ServiceServico servicoServico;

	@Autowired
	private ServicoRepositorio servRepositorio;

	@Autowired
	private UtilsDTO utilsDTO;
	
	@PostMapping("adicionar")	
	public ResponseEntity adicionar(@RequestBody ServicoDTO DTOservico) {

		Servico servico = Servico.builder().nomeServico(DTOservico.getNmServico()).build();

		try {

			Servico servicoEcontrado = servicoServico
					.BuscarServico(servico.getNomeServico());

			if (servicoEcontrado != null) {
				return ResponseEntity.badRequest().body("Departameto já cadastrado");
			}

			Servico servSalvo = servicoServico.SalvarDadosServico(servico);

			// return new ResponseEntity(depSalvo, HttpStatus.CREATED);

			return ResponseEntity.ok(servSalvo);

		} catch (RegraNegocio e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PutMapping("atualizarServico/{codigoDp}")	
	public ResponseEntity atualizarServico(@PathVariable Long codigoDp, @RequestBody ServicoDTO DTOservico) {

		Servico depAtual = servicoServico.BuscarPorCodigo(codigoDp);

		if (depAtual == null) {
			return ResponseEntity.badRequest().body("Serviço não encontrado");
		}

		depAtual.setNomeServico(DTOservico.getNmServico());

		// BeanUtils.copyProperties(departamento, depAtual, "id");

		servRepositorio.save(depAtual);

		return ResponseEntity.ok(depAtual);
	}

	@GetMapping("buscarPorCodigo/{codigo}")
	public ServicoDTO buscarPorCodigo(@PathVariable Long codigo) {
		Servico servEncontrado = servicoServico.BuscarPorCodigo(codigo);

		// DepartamentoDTO depDTO = toDepartamento(depEncontrado);

		return utilsDTO.toDepartamento(servEncontrado);
	}

	@GetMapping("remover/{codigoDep}")	
	public ResponseEntity remover(@PathVariable Long codigoDep) {

		Servico servEncontrado = servicoServico.BuscarPorCodigo(codigoDep);

		if (servEncontrado == null) {
			return ResponseEntity.badRequest().body("Serviço não encontrado");
		}

		Servico servExcluido = servicoServico.RemoverServico(servEncontrado);

		return ResponseEntity.ok(servExcluido);
	}

	@GetMapping("ativar/{codigoSer}")
	public ResponseEntity ativar(@PathVariable Long codigoSer) {
		
		Servico servicoEncontrado = servicoServico.BuscarPorCodigo(codigoSer);
		
		if (servicoEncontrado == null) {
			return ResponseEntity.badRequest().body("Serviço não encontrado");
		}
		
		Servico servAtivado = servicoServico.AtivarServico(servicoEncontrado);
		
		return ResponseEntity.ok(servAtivado);
		
	}	
	
	
	@GetMapping("listar")	
	public List<Servico> listar() {
		
		return servicoServico.ListarServico();
		//return utilsDTO.toCollecitonDTO(servicoDepartamento.ListarDepartamento());
	}

	

}
