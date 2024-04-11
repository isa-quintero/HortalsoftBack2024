package com.hortalsoft.transactions.domain.repository;

import com.hortalsoft.transactions.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
