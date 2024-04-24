package com.hortalsoft.products.application.facades.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.DeletePriceRangeFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeletePriceRangeFacadeImpl implements DeletePriceRangeFacade {
    @Override
    public void execute(PriceRangeDTO dto) {
    }
}
