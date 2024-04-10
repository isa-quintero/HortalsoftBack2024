package com.hortalSoft.products.backend.domain.repository;


import com.hortalSoft.products.backend.domain.entity.PriceRangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceRangeRepository extends JpaRepository<PriceRangeEntity,Long> {
}
