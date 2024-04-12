package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.DocumentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentTypeEntity,Long> {
}
