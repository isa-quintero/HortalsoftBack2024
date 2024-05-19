package com.hortalsoft.transactions.domain.repository;

import com.hortalsoft.transactions.domain.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity, Integer> {
}
