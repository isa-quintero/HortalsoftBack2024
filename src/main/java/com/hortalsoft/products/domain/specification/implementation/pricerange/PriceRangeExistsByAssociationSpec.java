package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;

import java.util.List;

public class PriceRangeExistsByAssociationSpec extends AbstractSpecification<PriceRangeEntity>  {
    private final PriceRangeRepository priceRangeRepository;

    public PriceRangeExistsByAssociationSpec(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        List<PriceRangeEntity> existingPriceRange = priceRangeRepository.findByAssociationId(priceRangeEntity.getAssociationId());
        return existingPriceRange.isEmpty();
    }
}
