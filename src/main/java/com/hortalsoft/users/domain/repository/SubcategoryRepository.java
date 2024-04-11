package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity,Long> {
}
