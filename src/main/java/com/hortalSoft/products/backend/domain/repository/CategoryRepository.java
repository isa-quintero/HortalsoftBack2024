package com.hortalsoft.products.backend.domain.repository;


import com.hortalsoft.products.backend.domain.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
