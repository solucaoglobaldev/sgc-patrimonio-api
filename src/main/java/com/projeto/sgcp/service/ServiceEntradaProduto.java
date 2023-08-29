package com.projeto.sgcp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.sgcp.entidade.EntradaProduto;
import com.projeto.sgcp.repositorio.EntradaProdutoRepositorio;

@Service
public class ServiceEntradaProduto {

	
	@Autowired
	public EntradaProdutoRepositorio entradaProdutoRepositorio;
	
	
	
	@Transactional
	public EntradaProduto entradaProduto(EntradaProduto entradaProduto) {
		
		LocalDateTime dtEntrada = LocalDateTime.now();
		
		entradaProduto.setDtEntrada(dtEntrada);
		
		return entradaProdutoRepositorio.save(entradaProduto);
	}
	
	
	@Transactional(readOnly = true)
	public List<EntradaProduto> listarEntradaProduto(){
		
		return entradaProdutoRepositorio.findAll();
	}
	
}
