package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.PriceRangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRangeRepository extends JpaRepository<PriceRangeEntity,Long> {
}
