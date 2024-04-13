package com.hortalsoft.products.application.service.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.service.facade.pricerange.ListPricesRangesFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListPricesRangesFacadeImpl implements ListPricesRangesFacade {
    @Override
    public List<PriceRangeDTO> execute(Optional<PriceRangeDTO> dto) {
        return List.of();
    }
}
