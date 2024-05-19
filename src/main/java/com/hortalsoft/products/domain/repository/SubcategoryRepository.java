package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity, Integer> {
}
