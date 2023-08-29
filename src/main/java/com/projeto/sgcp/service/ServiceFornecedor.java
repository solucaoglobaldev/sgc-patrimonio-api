package com.projeto.sgcp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.sgcp.entidade.Fornecedor;
import com.projeto.sgcp.entidade.Servico;
import com.projeto.sgcp.enuns.Status;
import com.projeto.sgcp.repositorio.FornecedorRepositorio;

@Service
public class ServiceFornecedor {
	
	@Autowired
	private FornecedorRepositorio repositorioFornecedor;
	
	
	@Transactional
	public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
		
		LocalDate dtCadastro = LocalDate.now();
		
		fornecedor.setDtCadastro(dtCadastro);
		
		fornecedor.setStatus(Status.ATIVO);
		
		return repositorioFornecedor.save(fornecedor);
		
	}
	
	@Transactional
	public Fornecedor atualizarFonecedor(Fornecedor fornecedor) {
		
		Objects.requireNonNull(fornecedor.getCnpj());
		
		return repositorioFornecedor.save(fornecedor);
	}
	
	@Transactional
	public Fornecedor intativarFornecedor(Fornecedor fornecedor) {
		
		fornecedor.setStatus(Status.INATIVO);
		
		return repositorioFornecedor.save(fornecedor);
	}
	
	@Transactional
	public Fornecedor ativarFornecedor(Fornecedor fornecedor) {
		
		fornecedor.setStatus(Status.ATIVO);
		
		return repositorioFornecedor.save(fornecedor);
	}
	
	@Transactional(readOnly = true)
	public List<Fornecedor> listarFornecedor(){
		
		return repositorioFornecedor.findAll();
	}
	
	@Transactional
	public Fornecedor bucarPorCNPJ(String cnpj) {
		
		return repositorioFornecedor.findBycnpj(cnpj); 
		
	}

}



