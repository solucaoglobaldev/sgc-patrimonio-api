package com.projeto.sgcp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sgcp.entidade.Fornecedor;
import com.projeto.sgcp.entidade.FormacaoPrecoProduto;

public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Long> {
	
	Fornecedor findBycnpj(String cnpj);

}
