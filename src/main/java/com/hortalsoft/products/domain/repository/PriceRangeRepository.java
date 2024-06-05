package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRangeRepository extends JpaRepository<PriceRangeEntity, Integer> {
    @Query("SELECT p FROM PriceRangeEntity p WHERE p.finalDatePriceRange >= CURRENT_DATE")
    List<PriceRangeEntity> findAllByFinalDateValid();

    @Query("SELECT p FROM PriceRangeEntity p WHERE p.finalDatePriceRange >= CURRENT_DATE AND p.idPriceRange =:id")
    Optional<PriceRangeEntity> findByFinalDateValidAndId(int id);

    List<PriceRangeEntity> findByAssociationIdAndProductId(int associationId, int productId);
}
