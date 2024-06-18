package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.FarmerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<FarmerEntity, Integer> {
}
