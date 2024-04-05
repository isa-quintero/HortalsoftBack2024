package com.hortalSoft.products.backend.infraestructure.adapter.repository.jpa;


import com.hortalSoft.products.backend.domain.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorioJpa extends JpaRepository<ProductoEntity, Long> {
    ProductoEntity findProductoEntitiesByName(String name);
}
