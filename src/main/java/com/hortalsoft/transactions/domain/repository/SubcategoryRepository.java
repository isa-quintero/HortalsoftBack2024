package com.hortalsoft.transactions.domain.repository;

import com.hortalsoft.transactions.domain.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity,Long> {
}
