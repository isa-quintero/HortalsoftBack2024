package com.hortalSoft.products.backend.domain.repository;


import com.hortalSoft.products.backend.domain.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OfferRepository extends JpaRepository<OfferEntity,Long> {
}
