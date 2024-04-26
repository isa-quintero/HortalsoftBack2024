package com.hortalsoft.products.application.facades.implementation.pricerange;

import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.FindPriceRangeFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.FindPriceRangeUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindPriceRangeFacadeImpl implements FindPriceRangeFacade {
    MapperDTOToDomain<PriceRangeDTO, PriceRange> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<PriceRange, PriceRangeDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindPriceRangeUseCase useCase;

    public FindPriceRangeFacadeImpl(FindPriceRangeUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public PriceRangeDTO execute(PriceRangeDTO dto) {
        PriceRange domain = mapperDTOToDomain.mapToDomain(dto,PriceRange.class);
        return mapperDomainToDto.mapToDto(useCase.execute(domain),PriceRangeDTO.class);
    }
}