package com.projeto.sgcp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sgcp.entidade.FormacaoPrecoProduto;
import com.projeto.sgcp.entidade.Servico;

public interface ProdutoRepositorio extends JpaRepository<FormacaoPrecoProduto, Long> {
	
	


}
