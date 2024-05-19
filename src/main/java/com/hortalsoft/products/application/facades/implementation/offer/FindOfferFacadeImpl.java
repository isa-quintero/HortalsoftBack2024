package com.hortalsoft.products.application.facades.implementation.offer;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.FindOfferFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.port.input.offer.FindOfferUseCase;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindOfferFacadeImpl implements FindOfferFacade {
    MapperDTOToDomain<OfferDTO, Offer> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Offer, OfferDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindOfferUseCase useCase;
    private final static Layer layer = Layer.APPLICATION;

    public FindOfferFacadeImpl(FindOfferUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the find offer use case.
     *
     * @param dto the offer DTO
     * @return the offer DTO
     * @throws ExceptionHortalsoft if an exception occurs
     */
    @Override
    public OfferDTO execute(OfferDTO dto) {
        try {
            Offer domain = mapperDTOToDomain.mapToDomain(dto, Offer.class);
            return mapperDomainToDto.mapToDto(useCase.execute(domain), OfferDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
