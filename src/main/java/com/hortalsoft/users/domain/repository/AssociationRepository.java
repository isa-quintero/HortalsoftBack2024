package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.AssociationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociationRepository  extends JpaRepository<AssociationEntity, Integer> {
}
