package com.hortalsoft.products.backend.infrastructure.adapter.repository.jpa;


import com.hortalsoft.products.backend.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface jpaProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findProductEntityByName(String name);
}
