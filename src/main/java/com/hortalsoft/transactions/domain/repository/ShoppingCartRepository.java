package com.hortalsoft.transactions.domain.repository;

import com.hortalsoft.transactions.domain.entity.ShppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShppingCartEntity, Integer> {
}
