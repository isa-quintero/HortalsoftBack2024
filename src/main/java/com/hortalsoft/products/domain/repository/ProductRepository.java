package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    boolean existsByName(String name);
    boolean existsById(long id);

}
