package com.hortalSoft.products.backend.infrastructure.adapter.repository.jpa;


import com.hortalSoft.products.backend.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface jpaProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findProductEntityByName(String name);
}
