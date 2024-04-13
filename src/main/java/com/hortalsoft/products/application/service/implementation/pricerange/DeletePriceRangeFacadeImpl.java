package com.hortalsoft.products.application.service.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.service.facade.pricerange.DeletePriceRangeFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeletePriceRangeFacadeImpl implements DeletePriceRangeFacade {
    @Override
    public PriceRangeDTO execute(PriceRangeDTO dto) {
        return null;
    }
}
