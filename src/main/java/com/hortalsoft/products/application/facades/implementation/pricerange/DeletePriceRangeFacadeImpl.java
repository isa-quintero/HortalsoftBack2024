package com.hortalsoft.products.application.facades.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.DeletePriceRangeFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.DeletePriceRangeUseCase;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeletePriceRangeFacadeImpl implements DeletePriceRangeFacade {
    MapperDTOToDomain<PriceRangeDTO, PriceRange> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final DeletePriceRangeUseCase useCase;

    public DeletePriceRangeFacadeImpl(DeletePriceRangeUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(PriceRangeDTO dto) {
        try{
            PriceRange domain = mapperDTOToDomain.mapToDomain(dto, PriceRange.class);
            useCase.execute(domain);
        }
        catch(ExceptionHortalsoft ex){
            throw  ex;
        }
    }
}
