package com.hortalsoft.products.application.facades.implementation.offer;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.ListOfferFacade;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.port.input.offer.ListOfferUseCase;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListOfferFacadeImpl implements ListOfferFacade {

    MapperDomainToDto<Offer, OfferDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListOfferUseCase useCase;
    private final Layers layer = Layers.APPLICATION;

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
    public List<OfferDTO> execute() {
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), OfferDTO.class);
        }catch(ExceptionHortalsoft exceptionHortalsoft){
            throw exceptionHortalsoft;
        }catch(Exception exception){
            throw new ExceptionHortalsoft("Ha ocurrido un error",500, layer, exception);
        }
    }
}
