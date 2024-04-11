package com.hortalsoft.products.backend.domain.repository;


import com.hortalsoft.products.backend.domain.entity.PriceRangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceRangeRepository extends JpaRepository<PriceRangeEntity,Long> {
}
