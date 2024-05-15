package com.hortalsoft.products.application.facades.implementation.pricerange;

import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.FindPriceRangeFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.FindPriceRangeUseCase;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindPriceRangeFacadeImpl implements FindPriceRangeFacade {
    MapperDTOToDomain<PriceRangeDTO, PriceRange> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<PriceRange, PriceRangeDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindPriceRangeUseCase useCase;
    private final Layers layer = Layers.APPLICATION;

    public FindPriceRangeFacadeImpl(FindPriceRangeUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the FindPriceRangeFacadeImpl by mapping the given PriceRangeDTO to a PriceRange domain object,
     * and then executing the useCase to find the price range. The result is then mapped back to a PriceRangeDTO
     * and returned.
     *
     * @param dto The PriceRangeDTO object containing the data to be mapped and used for finding the price range.
     * @return The PriceRangeDTO object representing the found price range.
     * @throws ExceptionHortalsoft if an ExceptionHortalsoft is caught during the execution.
     */
    @Override
    public PriceRangeDTO execute(PriceRangeDTO dto) {
        try {
            PriceRange domain = mapperDTOToDomain.mapToDomain(dto, PriceRange.class);
            return mapperDomainToDto.mapToDto(useCase.execute(domain), PriceRangeDTO.class);
        }catch(ExceptionHortalsoft exceptionHortalsoft){
            throw exceptionHortalsoft;
        }catch(Exception exception){
            throw new ExceptionHortalsoft("Ha ocurrido un error",500, layer, exception);
        }
    }
}
