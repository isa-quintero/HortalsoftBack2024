package com.hortalsoft.transactions.domain.repository;

import com.hortalsoft.transactions.domain.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<OfferEntity,Long> {
}
