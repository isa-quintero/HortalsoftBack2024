package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PriceRangeRepository extends JpaRepository<PriceRangeEntity, Integer> {
    /*@Query("SELECT p FROM PriceRangeEntity p WHERE p.finalDate >= CURRENT_DATE")
    List<PriceRangeEntity> findAllByFinalDateValid();

    @Query("SELECT p FROM PriceRangeEntity p WHERE p.finalDate >= CURRENT_DATE AND p.id =:id")
    Optional<PriceRangeEntity> findByFinalDateValidAndId(int id);*/

    boolean existsByAssociationIdAndInitialDateAndProductId(int association_id, LocalDate initialDate, int productId);
}
