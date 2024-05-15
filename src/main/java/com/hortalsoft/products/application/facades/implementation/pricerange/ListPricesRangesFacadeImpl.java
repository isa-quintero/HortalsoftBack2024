package com.hortalsoft.products.application.facades.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.ListPricesRangesFacade;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.ListPricesRangesUseCase;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListPricesRangesFacadeImpl implements ListPricesRangesFacade {

    MapperDomainToDto<PriceRange, PriceRangeDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListPricesRangesUseCase useCase;
    private final Layers layer = Layers.APPLICATION;

    public ListPricesRangesFacadeImpl(ListPricesRangesUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the list prices ranges use case and maps the result to a list of PriceRangeDTO objects.
     *
     * @return A list of PriceRangeDTO objects representing the price ranges.
     * @throws ExceptionHortalsoft if an ExceptionHortalsoft is thrown during the execution.
     */
    @Override
    public List<PriceRangeDTO> execute() {
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), PriceRangeDTO.class);
        }catch(ExceptionHortalsoft exceptionHortalsoft){
            throw exceptionHortalsoft;
        }catch(Exception exception){
            throw new ExceptionHortalsoft("Ha ocurrido un error",500, layer, exception);
        }
    }
}
