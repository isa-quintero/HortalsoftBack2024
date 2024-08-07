package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

public class AvailableOffersSpec extends AbstractSpecification<OfferEntity> {
    private final AbstractSpecification<OfferEntity> reglaA;
    private final AbstractSpecification<OfferEntity> reglaB;

    public AvailableOffersSpec(OfferRepository offerRepository) {
        reglaA = new OfferExistByIdSpec(offerRepository);
        reglaB = new OfferVerifyValiditySpec();
    }

    @Override
    public boolean isSatisfiedBy(OfferEntity offerEntity) {
        return reglaA.and(reglaB).isSatisfiedBy(offerEntity);
    }
}
