package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<OfferEntity,Integer> {
    List<OfferEntity> findAllByProduct_IdAndIdFarmer(Integer productId, Integer codeFarmer);
    List<OfferEntity> findByIdFarmer(Integer codeFarmer);

}
