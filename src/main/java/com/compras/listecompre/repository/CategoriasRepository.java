package com.compras.listecompre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.listecompre.domain.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long>{

	List<Categoria> findByNome(String nome);
}
