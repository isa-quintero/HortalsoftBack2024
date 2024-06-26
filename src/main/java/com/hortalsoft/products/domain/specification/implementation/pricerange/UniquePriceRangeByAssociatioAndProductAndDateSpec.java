package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.crosscutting.helper.DateHelper;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

import java.time.LocalDateTime;
import java.util.List;

public class UniquePriceRangeByAssociatioAndProductAndDateSpec extends AbstractSpecification<PriceRangeEntity> {


    private final PriceRangeRepository priceRangeRepository;

    public UniquePriceRangeByAssociatioAndProductAndDateSpec(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        Integer associationId = priceRangeEntity.getAssociationId();
        ProductEntity productId = priceRangeEntity.getProduct();
        LocalDateTime initialDate = priceRangeEntity.getInitialDatePriceRange();
        LocalDateTime finalDate = priceRangeEntity.getFinalDatePriceRange();


        List<PriceRangeEntity> existingPriceRanges = priceRangeRepository.findByAssociationIdAndProduct(associationId, productId);

        return existingPriceRanges.stream().filter(o ->
                DateHelper.isBetweenInclusive(o.getInitialDatePriceRange(), initialDate, finalDate) ||
                        DateHelper.isBetweenInclusive(o.getFinalDatePriceRange(), initialDate, finalDate)
        ).toList().isEmpty();
    }

}
