package com.projeto.sgcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.sgcp.entidade.CadastroProduto;
import com.projeto.sgcp.exception.RegraNegocio;
import com.projeto.sgcp.repositorio.CadastroProdutoRepositorio;
import com.projeto.sgcp.service.ServiceCadastroProduto;

@RequestMapping("api/produtos")
@RestController
public class ControllerCadastroProduto {

	@Autowired
	public ServiceCadastroProduto serviceCadastroProduto;

	@Autowired
	public CadastroProdutoRepositorio cadastroProdutoRepositorio;

	@PostMapping("adicionar")
	public ResponseEntity adicionar(@RequestBody CadastroProduto produto) {

		try {
			CadastroProduto descricaoEncontrada = cadastroProdutoRepositorio
					.findBydescricaoProduto(produto.getDescricaoProduto());

			if (descricaoEncontrada != null) {

				return ResponseEntity.badRequest().body("Produto cadastrado com essa descrição");

			}

			return ResponseEntity.ok(serviceCadastroProduto.salvarProduto(produto));

		} catch (RegraNegocio e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	@PutMapping("atualizar/{id}")
	public ResponseEntity atualizarProduto(@PathVariable Long id, @RequestBody CadastroProduto produto) {
		
		CadastroProduto produtoDescricaoAtual = cadastroProdutoRepositorio.findBycodigoProduto(id);
		
		if (produtoDescricaoAtual == null) {
			return ResponseEntity.badRequest().body("Produto informado não encontrado");
		}
		
		produtoDescricaoAtual.setDescricaoProduto(produto.getDescricaoProduto());
		
		cadastroProdutoRepositorio.save(produtoDescricaoAtual);
		
		return ResponseEntity.ok(produtoDescricaoAtual);
	}
	
	@GetMapping("inativar/{id}")
	public ResponseEntity inativar(@PathVariable Long id) {
		
		CadastroProduto produtoEncontrado = cadastroProdutoRepositorio.findBycodigoProduto(id);
		
		if (produtoEncontrado == null) {
			return ResponseEntity.badRequest().body("Produto informado não encontrado");
		}
		
		CadastroProduto produtoInativado = serviceCadastroProduto.inativarProduto(produtoEncontrado);
		
		return ResponseEntity.ok(produtoInativado);	
		
	}
	
	@GetMapping("ativar/{id}")
	public ResponseEntity ativar(@PathVariable Long id) {
		
		CadastroProduto produtoEncontrado = cadastroProdutoRepositorio.findBycodigoProduto(id);
		
		if (produtoEncontrado == null) {
			return ResponseEntity.badRequest().body("Produto informado não encontrado");
		}
		
		CadastroProduto produtoAivado = serviceCadastroProduto.ativarProduto(produtoEncontrado);
		
		return ResponseEntity.ok(produtoAivado);
		
	}
	
	@GetMapping("/listar")	
	public ResponseEntity<List<CadastroProduto>> listar() {
	    List<CadastroProduto> produtos = serviceCadastroProduto.listarProduto();
	    return ResponseEntity.ok(produtos);
	}


}
