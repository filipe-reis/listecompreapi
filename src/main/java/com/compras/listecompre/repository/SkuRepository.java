package com.compras.listecompre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.listecompre.domain.Sku;

public interface SkuRepository extends JpaRepository<Sku, Long> {

}
