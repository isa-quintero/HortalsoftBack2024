package com.hortalsoft.products.application.facades.implementation.pricerange;

import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.FindPriceRangeFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindPriceRangeFacadeImpl implements FindPriceRangeFacade {
    @Override
    public PriceRangeDTO execute(PriceRangeDTO dto) {
        return null;
    }
}
