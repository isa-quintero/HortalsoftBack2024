package com.hortalsoft.products.application.facades.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.ListPricesRangesFacade;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.ListPricesRangesUseCase;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import com.hortalsoft.products.util.Layers;
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
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), PriceRangeDTO.class);
        }catch(Exception e){
            if (e instanceof ExceptionHortalsoft){
                throw (ExceptionHortalsoft) e;
            }else{
                throw new ExceptionHortalsoft(e.getMessage(),500, Layers.APPLICATION);
            }
        }
    }
}
