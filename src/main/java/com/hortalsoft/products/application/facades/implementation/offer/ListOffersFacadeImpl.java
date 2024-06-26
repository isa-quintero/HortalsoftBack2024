package com.hortalsoft.products.application.facades.implementation.offer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.ListOffersFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.port.input.offer.ListOfferUseCase;
import com.hortalsoft.products.domain.port.input.offer.ListOffersUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListOffersFacadeImpl implements ListOffersFacade {

    MapperDomainToDto<Offer, OfferDTO> mapperDomainToDto = new MapperDomainToDto<>();
    MapperDTOToDomain<OfferDTO, Offer> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final ListOffersUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public ListOffersFacadeImpl(ListOffersUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the list offer use case and maps the resulting domain objects to DTOs.
     *
     * @return a list of OfferDTO objects representing the offers
     * @throws ExceptionHortalsoft if an error occurs during the execution of the use case
     */
    @Override
    public List<OfferDTO> execute() {
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), OfferDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
