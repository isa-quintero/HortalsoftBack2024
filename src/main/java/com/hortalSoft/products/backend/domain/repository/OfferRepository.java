package com.hortalsoft.products.backend.domain.repository;


import com.hortalsoft.products.backend.domain.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OfferRepository extends JpaRepository<OfferEntity,Long> {
}
