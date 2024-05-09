package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OfferRepository extends JpaRepository<OfferEntity,Integer> {
    OfferRepository findByProduct_IdAndInitialDateAndCodeFarmer(int codeProduct, LocalDate initialDate, int codeFarmer);
    List<OfferEntity> findByCodeFarmer(int codeFarmer);

}
