package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface OfferRepository extends JpaRepository<OfferEntity,Long> {
    OfferRepository findByCodeProductAndInitialDateAndCodeFarmer(long codeProduct, Date initialDate,long codeFarmer);
}
