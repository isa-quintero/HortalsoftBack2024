package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<CustomerEntity, Integer> {
}
