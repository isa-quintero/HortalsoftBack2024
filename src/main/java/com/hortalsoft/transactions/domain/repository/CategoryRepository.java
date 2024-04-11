package com.hortalsoft.transactions.domain.repository;

import com.hortalsoft.transactions.domain.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
