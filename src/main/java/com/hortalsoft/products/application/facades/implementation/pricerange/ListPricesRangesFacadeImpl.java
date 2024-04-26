package com.hortalsoft.products.application.facades.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.ListPricesRangesFacade;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.ListPricesRangesUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListPricesRangesFacadeImpl implements ListPricesRangesFacade {

    MapperDomainToDto<PriceRange, PriceRangeDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListPricesRangesUseCase useCase;

    public ListPricesRangesFacadeImpl(ListPricesRangesUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<PriceRangeDTO> execute() {
        return mapperDomainToDto.mapToDtoList(useCase.execute(),PriceRangeDTO.class);
    }
}
