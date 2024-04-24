package com.hortalsoft.products.application.facades.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.CreatePriceRangeFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreatePriceRangeFacadeImpl implements CreatePriceRangeFacade {
    @Override
    public void execute(PriceRangeDTO dto) {
    }
}
