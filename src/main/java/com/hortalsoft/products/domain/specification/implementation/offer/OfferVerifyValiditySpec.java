package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

public class OfferVerifyValiditySpec extends AbstractSpecification<OfferEntity> {

    public OfferVerifyValiditySpec() {
    }

    @Override
    public boolean isSatisfiedBy(OfferEntity offerEntity) {
        return !offerEntity.isValidity(); // Verifica si validity es false
    }
}
