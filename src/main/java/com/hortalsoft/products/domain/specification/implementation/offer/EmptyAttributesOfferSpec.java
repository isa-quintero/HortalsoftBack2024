package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.products.domain.entity.OfferEntity;

import java.util.Objects;

public class EmptyAttributesOfferSpec extends AbstractSpecification<OfferEntity> {

    @Override
    public boolean isSatisfiedBy(OfferEntity offer) {
        return (Objects.equals(offer.getProduct(), 0) || Objects.equals(offer.getFarmer(), 0) ||
                Objects.equals(offer.getAmount(), 0) || Objects.equals(offer.getPrice(), 0));

    }
}
