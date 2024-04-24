package com.hortalsoft.products.application.facades.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.ListPricesRangesFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListPricesRangesFacadeImpl implements ListPricesRangesFacade {


    @Override
    public List<PriceRangeDTO> execute() {
        return List.of();
    }
}
