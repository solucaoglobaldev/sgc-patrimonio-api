package com.projeto.sgcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.sgcp.entidade.CadastroProduto;
import com.projeto.sgcp.entidade.EntradaProduto;
import com.projeto.sgcp.entidade.Servico;
import com.projeto.sgcp.repositorio.CadastroProdutoRepositorio;
import com.projeto.sgcp.service.ServiceEntradaProduto;

@RestController
@RequestMapping("api/entradas")
public class ControllerEntradaProduto {

	@Autowired
	public ServiceEntradaProduto serviceEntradaProduto;
	
	@Autowired
	public CadastroProdutoRepositorio cadastroProdutoRepositorio;
	
	
	@PostMapping("adicionar")
	public ResponseEntity adicionar(@RequestBody EntradaProduto entradaProduto) {		
		
		return ResponseEntity.ok(serviceEntradaProduto.entradaProduto(entradaProduto));	
		
	}
	
	@GetMapping("listarentrada")
	public ResponseEntity<List<EntradaProduto>> listarEntrada() {
		List<EntradaProduto> entradaProdutos = serviceEntradaProduto.listarEntradaProduto();

		return ResponseEntity.ok(entradaProdutos);

	}

}
