package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;


public class ValidateOfferToBeCreatedSpec extends AbstractSpecification<OfferEntity> {
    private final AbstractSpecification<OfferEntity> reglaA;
    private final AbstractSpecification<OfferEntity> reglaB;

    public ValidateOfferToBeCreatedSpec(OfferRepository offerRepository) {
        reglaA = new ExistingOfferOverlapSpecification(offerRepository);
        reglaB = new ValidatePriceAndAmountOfferSpec();
    }

    @Override
    public boolean isSatisfiedBy(OfferEntity offerEntity) {
        return reglaA.and(reglaB).isSatisfiedBy(offerEntity);
    }

}
