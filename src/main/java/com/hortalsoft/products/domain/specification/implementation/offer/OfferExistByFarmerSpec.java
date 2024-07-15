package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.repository.OfferRepository;

import java.util.List;


public class OfferExistByFarmerSpec extends AbstractSpecification<OfferEntity> {
    private final OfferRepository offerRepository;

    public OfferExistByFarmerSpec(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public boolean isSatisfiedBy(OfferEntity offerEntity) {
        List<OfferEntity> existingOffer = offerRepository.findByFarmer(offerEntity.getOfferId());
        return existingOffer.isEmpty();
    }
}
