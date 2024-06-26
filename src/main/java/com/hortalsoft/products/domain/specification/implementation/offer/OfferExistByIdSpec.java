package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

import java.util.Objects;
import java.util.Optional;

public class OfferExistByIdSpec extends AbstractSpecification<OfferEntity> {
    private final OfferRepository offerRepository;

    public OfferExistByIdSpec(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public boolean isSatisfiedBy(OfferEntity offerEntity) {
        Optional<OfferEntity> existingOffer = offerRepository.findById(offerEntity.getOfferId());
        return existingOffer.filter(entity -> Objects.equals(entity.getOfferId(), offerEntity.getOfferId())).isPresent();
    }
}
