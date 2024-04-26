package com.hortalsoft.products.application.facades.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.CreatePriceRangeFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.CreatePriceRangeUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

@Service
@Transactional
public class CreatePriceRangeFacadeImpl implements CreatePriceRangeFacade {
    MapperDTOToDomain<PriceRangeDTO, PriceRange> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final CreatePriceRangeUseCase useCase;

    public CreatePriceRangeFacadeImpl(CreatePriceRangeUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(PriceRangeDTO dto) {
        try{
            PriceRange domain = mapperDTOToDomain.mapToDomain(dto, PriceRange.class);
            useCase.execute(domain);
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}
