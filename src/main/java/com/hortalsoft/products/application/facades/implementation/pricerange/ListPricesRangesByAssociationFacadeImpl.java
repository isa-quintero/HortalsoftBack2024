package com.hortalsoft.products.application.facades.implementation.pricerange;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.ListPricesRangesByAssociationFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.ListPricesRangesByAssociationUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListPricesRangesByAssociationFacadeImpl implements ListPricesRangesByAssociationFacade {

    MapperDTOToDomain<PriceRangeDTO, PriceRange> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<PriceRange, PriceRangeDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListPricesRangesByAssociationUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public ListPricesRangesByAssociationFacadeImpl(ListPricesRangesByAssociationUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the list prices ranges use case and maps the result to a list of PriceRangeDTO objects.
     *
     * @return A list of PriceRangeDTO objects representing the price ranges.
     * @throws ExceptionHortalsoft if an ExceptionHortalsoft is thrown during the execution.
     */
    @Override
    public List<PriceRangeDTO> execute(PriceRangeDTO dto) {
        try {
            PriceRange domain = mapperDTOToDomain.mapToDomain(dto, PriceRange.class);
            return mapperDomainToDto.mapToDtoList(useCase.execute(domain), PriceRangeDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error", 500, layer, exception);
        }
    }
}
