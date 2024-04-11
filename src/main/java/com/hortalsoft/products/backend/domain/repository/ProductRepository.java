package com.hortalsoft.products.backend.domain.repository;


import com.hortalsoft.products.backend.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
