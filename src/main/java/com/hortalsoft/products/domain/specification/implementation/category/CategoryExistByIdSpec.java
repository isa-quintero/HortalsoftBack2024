package com.hortalsoft.products.domain.specification.implementation.category;

import com.hortalsoft.products.domain.entity.CategoryEntity;
import com.hortalsoft.products.domain.repository.CategoryRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

import java.util.Objects;
import java.util.Optional;

public class CategoryExistByIdSpec extends AbstractSpecification<CategoryEntity> {
    private final CategoryRepository categoryRepository;

    public CategoryExistByIdSpec(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isSatisfiedBy(CategoryEntity categoryEntity) {
        Optional<CategoryEntity> existingOffer = categoryRepository.findById(categoryEntity.getId());
        return existingOffer.filter(entity -> Objects.equals(entity.getId(), categoryEntity.getId())).isPresent();
    }
}
