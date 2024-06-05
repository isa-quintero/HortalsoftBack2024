package com.hortalsoft.products.application.facades.implementation.offer;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.ListOfferFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.port.input.offer.ListOfferUseCase;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListOfferFacadeImpl implements ListOfferFacade {

    MapperDomainToDto<Offer, OfferDTO> mapperDomainToDto = new MapperDomainToDto<>();
    MapperDTOToDomain<OfferDTO, Offer> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final ListOfferUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public ListOfferFacadeImpl(ListOfferUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the list offer use case and maps the resulting domain objects to DTOs.
     *
     * @return a list of OfferDTO objects representing the offers
     * @throws ExceptionHortalsoft if an error occurs during the execution of the use case
     */
    @Override
    public List<OfferDTO> execute(OfferDTO dto) {
        try {
            Offer domain = mapperDTOToDomain.mapToDomain(dto, Offer.class);
            return mapperDomainToDto.mapToDtoList(useCase.execute(domain), OfferDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
