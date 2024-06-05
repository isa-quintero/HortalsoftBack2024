package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.crosscutting.helper.DateHelper;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

import java.time.LocalDateTime;

public class OfferVerifyDateSpec extends AbstractSpecification<OfferEntity> {

    public OfferVerifyDateSpec() {
    }

    @Override
    public boolean isSatisfiedBy(OfferEntity offerEntity) {
        return (DateHelper.isGreaterOrEqual(offerEntity.getFinalDateOffer(), LocalDateTime.now()) &&
                DateHelper.isGreaterOrEqual(offerEntity.getInitialDateOffer(), LocalDateTime.now()) &&
                DateHelper.isGreaterOrEqual(offerEntity.getFinalDateOffer(), offerEntity.getInitialDateOffer())
        );
    }
}
