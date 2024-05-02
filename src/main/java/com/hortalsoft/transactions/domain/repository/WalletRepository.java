package com.hortalsoft.transactions.domain.repository;

import com.hortalsoft.transactions.domain.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<WalletEntity, Integer> {
    @Query("SELECT p FROM WalletEntity p WHERE p.finalDate >= CURRENT_DATE")
    List<WalletEntity> findAllByFinalDateValid();

    @Query("SELECT p FROM WalletEntity p WHERE p.finalDate >= CURRENT_DATE AND p.id =:id")
    Optional<WalletEntity> findByFinalDateValidAndId(int id);

    boolean existsByAssociationIdAndInitialDateAndProductId(int association_id, LocalDate initialDate, int productId);
}
