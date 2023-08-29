package com.projeto.sgcp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sgcp.entidade.CadastroProduto;

public interface CadastroProdutoRepositorio extends JpaRepository<CadastroProduto, Long> {
	
	
	CadastroProduto findBycodigoProduto(Long id);

	CadastroProduto  findBydescricaoProduto (String descricao);
	

}
