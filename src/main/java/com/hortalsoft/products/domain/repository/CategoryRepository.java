package com.hortalsoft.products.domain.repository;

import com.hortalsoft.products.domain.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
