package com.hortalsoft.transactions.domain.repository;

import com.hortalsoft.transactions.domain.entity.PriceRangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRangeRepository extends JpaRepository<PriceRangeEntity,Long> {
}
