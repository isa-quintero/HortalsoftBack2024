package com.hortalsoft.products.application.service.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.service.facade.pricerange.CreatePriceRangeFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreatePriceRangeFacadeImpl implements CreatePriceRangeFacade {
    @Override
    public void execute(PriceRangeDTO dto) {
    }
}
