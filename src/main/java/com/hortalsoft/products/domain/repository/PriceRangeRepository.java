package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRangeRepository extends JpaRepository<PriceRangeEntity,Long> {
}
