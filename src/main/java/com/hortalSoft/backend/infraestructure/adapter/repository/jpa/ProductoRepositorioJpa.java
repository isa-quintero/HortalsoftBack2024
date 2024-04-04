package com.hortalSoft.backend.infraestructure.adapter.repository.jpa;

import com.hortalSoft.backend.domain.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorioJpa extends JpaRepository<ProductoEntity, Long> {
    ProductoEntity findProductoEntitiesByName(String name);
}
