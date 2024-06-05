package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

public class OfferVerifyValiditySpec extends AbstractSpecification<OfferEntity> {
    private final OfferRepository offerRepository;

    public OfferVerifyValiditySpec(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public boolean isSatisfiedBy(OfferEntity offerEntity) {
        return !offerEntity.isValidity(); // Verifica si validity es false
    }
}
