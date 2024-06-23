package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.crosscutting.helper.NumberHelper;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;



public class OfferVerifyPriceSpec extends AbstractSpecification<OfferEntity> {

    public OfferVerifyPriceSpec() {
    }

    @Override
    public boolean isSatisfiedBy(OfferEntity offerEntity) {
        return (NumberHelper.greaterThan(offerEntity.getPrice(),0));
    }
}
