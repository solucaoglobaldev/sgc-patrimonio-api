//package com.projeto.sgcp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.projeto.sgcp.repositorio.ProdutoRepositorio;
//import com.projeto.sgcp.service.ServicoProduto;
//
//@RequestMapping("api/produto")
//@RestController
//public class ControllerProduto {
//
//	@Autowired
//	private ServicoProduto servicoProduto;
//	
//	@Autowired
//	private ProdutoRepositorio repositorioProduto;
//
////	@PostMapping("adicionar")
////	public ResponseEntity adicionar(@RequestBody ProdutoDTO produtoDTO) {
////
////		try {
////
////			FormacaoPrecoProduto produtoEncontratdo = repositorioProduto.findBydescricaoProduto(produtoDTO.getDescricaoProdutoDTO());
////			
////			if (produtoEncontratdo !=null) {
////				
////				return ResponseEntity.badRequest().body("Produto já casdastrado com esse nome");
////			}
////			
////			
////			
////			FormacaoPrecoProduto produtoSalvo = convertProduto(produtoDTO);
////
////			produtoSalvo = servicoProduto.salvarProduto(produtoSalvo);
////
////			return ResponseEntity.ok(produtoSalvo);
////
////		} catch (Exception e) {
////			return ResponseEntity.badRequest().body(e.getMessage());
////		}
////
////	}
//
////	@GetMapping("intativarProduto/{codProduto}")
////	public ResponseEntity intativarProduto(@PathVariable Integer codProduto) {
////
////		FormacaoPrecoProduto produtoEncontrado = servicoProduto.buscarPorCodito(codProduto);
////
////		if (produtoEncontrado == null) {
////
////			return ResponseEntity.badRequest().body("Produto não encontrado");
////		}
////
////		FormacaoPrecoProduto produtoInativado = servicoProduto.intativarProduto(produtoEncontrado);
////
////		return ResponseEntity.ok(produtoInativado);
////
////	}
//
////	private FormacaoPrecoProduto convertProduto(ProdutoDTO dtoProduto) {
////
////		FormacaoPrecoProduto produto = new FormacaoPrecoProduto();
////
////		
////		produto.setValorCompra(dtoProduto.getValorCompraDTO());
////
////		produto.setValorCusto(dtoProduto.getValorCustoDTO());
////
////		produto.setMargemLucro(dtoProduto.getMargemLucroDTO());
////
////		return produto;
////
////	}
//
////	@GetMapping("ativarProduto/{codProduto}")
////	public ResponseEntity ativarProduto(@PathVariable Integer codProduto) {
////
////		FormacaoPrecoProduto produtoEncontrado = servicoProduto.buscarPorCodito(codProduto);
////
////		if (produtoEncontrado == null) {
////
////			return ResponseEntity.badRequest().body("Produto não encontrado");
////		}
////
////		FormacaoPrecoProduto produtoAtivado = servicoProduto.ativarProduto(produtoEncontrado);
////
////		return ResponseEntity.ok(produtoAtivado);
////	}
//
////	@GetMapping("listar")
////	public List<FormacaoPrecoProduto> listar() {
////		return servicoProduto.listarProduto();
////	}
//
//}
