package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<OfferEntity,Integer> {
    List<OfferEntity> findAllByProductAndFarmer(ProductEntity productId, Integer codeFarmer);
    List<OfferEntity> findByFarmer(Integer codeFarmer);

}
