package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociationRepository  extends JpaRepository<AssociationEntity, Integer> {
    Optional<AssociationEntity> findByEmail(String email);

}
