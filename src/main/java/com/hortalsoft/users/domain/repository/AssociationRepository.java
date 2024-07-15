package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.AssociationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociationRepository  extends JpaRepository<AssociationEntity, Integer> {
    Optional<AssociationEntity> findByEmail(String email);
    Optional<AssociationEntity> findByNumberId(Long numberId);


}
