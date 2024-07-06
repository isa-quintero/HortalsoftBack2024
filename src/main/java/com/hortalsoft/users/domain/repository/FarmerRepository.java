package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.FarmerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmerRepository extends JpaRepository<FarmerEntity, Integer> {
    Optional<FarmerEntity> findByEmail(String email);

}
