package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
