package com.hortalsoft.products.application.facades.implementation.offer;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.ListOfferFacade;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.port.input.offer.ListOfferUseCase;
import com.hortalsoft.util.ExceptionHortalsoft;
import com.hortalsoft.util.Layers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListOfferFacadeImpl implements ListOfferFacade {

    MapperDomainToDto<Offer, OfferDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListOfferUseCase useCase;

    public ListOfferFacadeImpl(ListOfferUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<OfferDTO> execute() {
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), OfferDTO.class);
        }catch(ExceptionHortalsoft e){
            throw e;
        }catch(Exception e){
            throw new ExceptionHortalsoft(e.getMessage(),500, Layers.APPLICATION, e);
        }
    }
}
