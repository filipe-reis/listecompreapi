package com.compras.listecompre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.listecompre.domain.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long>{

}
