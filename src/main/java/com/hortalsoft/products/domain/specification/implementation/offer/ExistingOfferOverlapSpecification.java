package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.crosscutting.helper.DateHelper;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

import java.time.LocalDateTime;
import java.util.List;

public class ExistingOfferOverlapSpecification extends AbstractSpecification<OfferEntity> {
    private final OfferRepository offerRepository;

    public ExistingOfferOverlapSpecification(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public boolean isSatisfiedBy(OfferEntity offer) {
        Integer farmerId = offer.getFarmer();
        ProductEntity productId = offer.getProduct();
        LocalDateTime initialDateOffer = offer.getInitialDateOffer();
        LocalDateTime finalDate = offer.getFinalDateOffer();


        List<OfferEntity> existingOffers = offerRepository.findAllByProductAndFarmer(productId, farmerId);

        return existingOffers.stream().filter(o ->
                DateHelper.isBetweenInclusive(o.getInitialDateOffer(), initialDateOffer, finalDate) ||
                        DateHelper.isBetweenInclusive(o.getFinalDateOffer(), initialDateOffer, finalDate) ||
                        o.isValidity()
        ).toList().isEmpty();
    }
}