package com.hortalsoft.products.application.implementation.pricerange;

import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facade.pricerange.FindPriceRangeFacade;
import com.hortalsoft.products.domain.domain.PriceRange;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindPriceRangeFacadeImpl implements FindPriceRangeFacade {
    @Override
    public PriceRange execute(PriceRangeDTO dto) {
        return null;
    }
}
