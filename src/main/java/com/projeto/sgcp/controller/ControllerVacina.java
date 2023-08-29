package com.projeto.sgcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.sgcp.dto.VacinaDTO;
import com.projeto.sgcp.entidade.Vacina;
import com.projeto.sgcp.exception.RegraNegocio;
import com.projeto.sgcp.repositorio.VacinaRepositorio;
import com.projeto.sgcp.service.ServicoVacina;

@RequestMapping("api/vacina")
@Controller
public class ControllerVacina {

	@Autowired
	private ServicoVacina servicoVacina;

	@Autowired
	private VacinaRepositorio vacinaRepositorio;

	@PostMapping("adicionar")
	public ResponseEntity adicionar(@RequestBody VacinaDTO vacinaDTO) {

		Vacina vacina = Vacina.builder().nomeVacina(vacinaDTO.getNomeVacina())
				.codigoVacina(vacinaDTO.getCodigoVacina())
				.build();
		
		try {
			Vacina vacinaEncontrada = servicoVacina.buscarVacina(vacina.getNomeVacina());

			if (vacinaEncontrada != null) {
				return ResponseEntity.badRequest().body("Vacina já cadastrada");
			}

			Vacina vacinaSalva = servicoVacina.cadastrarVacina(vacina);

			return ResponseEntity.ok(vacinaSalva);

		} catch (RegraNegocio e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PutMapping("atualizarvacina/{codVacina}")
	public ResponseEntity atualizarVacina(@PathVariable String codVacina, @RequestBody Vacina vacina) {

		Vacina vacAtual = servicoVacina.buscarPorCodigo(codVacina);

		if (vacAtual == null) {

			return ResponseEntity.badRequest().body("Vacina não encontrado");
		}

		vacAtual.setNomeVacina(vacina.getNomeVacina());

		vacinaRepositorio.save(vacAtual);

		return ResponseEntity.ok(vacAtual);

	}

	@GetMapping("inativarvacina/{codVacina}")	
	public ResponseEntity inativarVacina(@PathVariable String codVacina) {

		Vacina vacinaEncontrada = servicoVacina.buscarPorCodigo(codVacina);

		if (vacinaEncontrada == null) {
			return ResponseEntity.badRequest().body("Vacina não encontrado");
		}

		Vacina vacinaInativada = servicoVacina.removerVacina(vacinaEncontrada);

		return ResponseEntity.ok(vacinaInativada);

	}
	
	@GetMapping("ativarvacina/{codVacina}")
	public ResponseEntity ativarVacina(@PathVariable String codVacina) {
		
		Vacina vacinaEncontrada = servicoVacina.buscarPorCodigo(codVacina);
		
		if (vacinaEncontrada == null) {
			
			return ResponseEntity.badRequest().body("Vacina não encontrado");
		}
		
		Vacina vacinaAtivada = servicoVacina.ativarVacina(vacinaEncontrada);
		
		return ResponseEntity.ok(vacinaAtivada);
	}
}
