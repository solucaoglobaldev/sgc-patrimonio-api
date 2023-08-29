package com.projeto.sgcp.service;
//package com.projeto.sgcp.service;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.projeto.sgcp.entidade.FormacaoPrecoProduto;
//import com.projeto.sgcp.enuns.Status;
//import com.projeto.sgcp.repositorio.ProdutoRepositorio;
//
//@Service
//public class ServicoProduto {
//
//	
//	@Transactional
//	public FormacaoPrecoProduto salvarProduto (FormacaoPrecoProduto produto) {
//		
//		LocalDate  dtCadastro = LocalDate.now();			
//		
//		BigDecimal margemLucro = BigDecimal.valueOf(produto.getMargemLucro() / 100);
//		
//		BigDecimal precoCompra = produto.getValorCompra();
//		
//		BigDecimal precoCusto = produto.getValorCusto();	
//		
//		BigDecimal valorCustoTotalProduto = precoCompra.add(precoCusto);	
//		
//		BigDecimal valorVenda = valorCustoTotalProduto.add(valorCustoTotalProduto.multiply(margemLucro));
//		
//		BigDecimal lucroObtido = valorVenda.subtract(valorCustoTotalProduto);
//		
//		produto.setValorVenda(valorVenda);
//		
//		produto.setDtCadastro(dtCadastro);	
//		
//		produto.setLucroObtido(lucroObtido);
//		
//		//return produtoRepositorio.save(produto);
//	}
//	
////	@Transactional(readOnly = true)
////	public List<FormacaoPrecoProduto> listarProduto() {		
////		return produtoRepositorio.findAll();
////		
////	}
//	
////	@Transactional
////	public FormacaoPrecoProduto atualizarProduto(FormacaoPrecoProduto produto) {
////		
////		Objects.requireNonNull(produto.getCodigoProduto());
////		
////		return produtoRepositorio.save(produto);
////	}
//	
////	@Transactional
////	public FormacaoPrecoProduto intativarProduto(FormacaoPrecoProduto produto) {
////		
////		produto.setStatusProduto(Status.INATIVO);
////		
////		return produtoRepositorio.save(produto);
////	}
////	
////	@Transactional
////	public FormacaoPrecoProduto ativarProduto (FormacaoPrecoProduto produto) {
////		
////		produto.setStatusProduto(Status.ATIVO);
////		
////		return produtoRepositorio.save(produto);
////	}
//	
//	@Transactional
//	public FormacaoPrecoProduto buscarPorCodito(Integer codProduto) {
//		
//		return produtoRepositorio.findBycodigoProduto(codProduto);
//		
//	}
//	
//	/*private String formatarData(LocalDate data) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        return data.format(formatter);
//    }*/
//	
//	
//	
//	
//}
