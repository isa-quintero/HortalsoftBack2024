package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<OfferEntity,Long> {
}
