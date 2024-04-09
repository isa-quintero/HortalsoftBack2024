package com.hortalSoft.products.backend.infrastructure.adapter.repository.jpa;


import com.hortalSoft.products.backend.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorioJpa extends JpaRepository<ProductEntity, Long> {
    ProductEntity findProductoEntitiesByName(String name);
}
