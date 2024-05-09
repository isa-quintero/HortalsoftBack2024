package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    boolean existsByName(String name);
    boolean existsById(int id);

    ProductEntity findByName(String productName);
}
