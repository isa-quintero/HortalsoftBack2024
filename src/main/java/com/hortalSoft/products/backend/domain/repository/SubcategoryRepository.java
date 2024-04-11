package com.hortalsoft.products.backend.domain.repository;


import com.hortalsoft.products.backend.domain.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity,Long> {
}
