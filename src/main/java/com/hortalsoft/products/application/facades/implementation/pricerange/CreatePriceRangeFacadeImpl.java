package com.hortalsoft.products.application.facades.implementation.pricerange;


import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.CreatePriceRangeFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.CreatePriceRangeUseCase;
import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreatePriceRangeFacadeImpl implements CreatePriceRangeFacade {
    MapperDTOToDomain<PriceRangeDTO, PriceRange> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final CreatePriceRangeUseCase useCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public CreatePriceRangeFacadeImpl(CreatePriceRangeUseCase useCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.useCase = useCase;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    /**
     * Executes the given PriceRangeDTO by mapping it to a PriceRange domain object and invoking the use case to execute the domain object.
     *
     * @param dto The PriceRangeDTO to be executed.
     */
    @Override
    public void execute(PriceRangeDTO dto) {
        try{
            PriceRange domain = mapperDTOToDomain.mapToDomain(dto, PriceRange.class);
            useCase.execute(domain);
        }catch(Exception exception){
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }
}
