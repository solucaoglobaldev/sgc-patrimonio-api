package com.projeto.sgcp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.sgcp.entidade.CadastroProduto;
import com.projeto.sgcp.enuns.Status;
import com.projeto.sgcp.repositorio.CadastroProdutoRepositorio;

@Service
public class ServiceCadastroProduto {
	
	@Autowired
	public CadastroProdutoRepositorio cadastroProdutoRepositorio;

	
	
	@Transactional
	public CadastroProduto salvarProduto(CadastroProduto produto) {
		
		LocalDate dtCadastroProduto = LocalDate.now();
		
		produto.setDtCadastro(dtCadastroProduto);
		
		produto.setStatus(Status.ATIVO);
		
		return cadastroProdutoRepositorio.save(produto);
	}
	
	@Transactional
	public CadastroProduto inativarProduto(CadastroProduto produto) {
		
		produto.setStatus(Status.INATIVO);
		
		return cadastroProdutoRepositorio.save(produto);
	}
	
	@Transactional
	public CadastroProduto ativarProduto(CadastroProduto produto) {
		
		produto.setStatus(Status.ATIVO);
		
		return cadastroProdutoRepositorio.save(produto);
	}
	
	@Transactional(readOnly = true)
	public List<CadastroProduto> listarProduto(){
		
		return cadastroProdutoRepositorio.findAll();
	}
	
	@Transactional
	public CadastroProduto atualizarCadastroProduto(CadastroProduto produto) {
		
		Objects.requireNonNull(produto.getCodigoProduto());
		
		return cadastroProdutoRepositorio.save(produto);
	}
}
