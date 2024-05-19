package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OfferRepository extends JpaRepository<OfferEntity,Integer> {
    OfferRepository findByProduct_IdAndInitialDateOfferAndIdFarmer(Integer productId, LocalDate initialDate, Integer codeFarmer);
    List<OfferEntity> findByIdFarmer(int codeFarmer);

}
