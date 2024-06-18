package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

public class PriceRangeVerifyAssociationSpec extends AbstractSpecification<PriceRangeEntity> {
    private final PriceRangeRepository priceRangeRepository;

    public PriceRangeVerifyAssociationSpec(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        return false;
    }
}
