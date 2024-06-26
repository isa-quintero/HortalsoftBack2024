package com.hortalsoft.transactions.domain.repository;

import com.hortalsoft.transactions.domain.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity,Integer> {
}
