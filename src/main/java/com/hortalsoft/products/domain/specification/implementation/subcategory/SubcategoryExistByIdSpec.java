package com.hortalsoft.products.domain.specification.implementation.subcategory;

import com.hortalsoft.products.domain.entity.SubcategoryEntity;
import com.hortalsoft.products.domain.repository.SubcategoryRepository;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

import java.util.Objects;
import java.util.Optional;

public class SubcategoryExistByIdSpec extends AbstractSpecification<SubcategoryEntity> {
    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryExistByIdSpec(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public boolean isSatisfiedBy(SubcategoryEntity subcategoryEntity) {
        Optional<SubcategoryEntity> existingOffer = subcategoryRepository.findById(subcategoryEntity.getIdSubcategory());
        return existingOffer.filter(entity -> Objects.equals(entity.getIdSubcategory(), subcategoryEntity.getIdSubcategory())).isPresent();
    }
}
