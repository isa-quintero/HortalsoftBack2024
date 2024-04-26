package com.hortalsoft.products.application.facades.implementation.offer;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.ListOfferFacade;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.port.input.offer.ListOfferUseCase;
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
        return mapperDomainToDto.mapToDtoList(useCase.execute(), OfferDTO.class);
    }
}
