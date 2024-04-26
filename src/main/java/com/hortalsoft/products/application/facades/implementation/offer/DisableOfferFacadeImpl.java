package com.hortalsoft.products.application.facades.implementation.offer;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.DisableOfferFacade;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.port.input.offer.DisableOfferUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

@Service
@Transactional
public class DisableOfferFacadeImpl implements DisableOfferFacade {
    MapperDTOToDomain<OfferDTO, Offer> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final DisableOfferUseCase useCase;


    public DisableOfferFacadeImpl(DisableOfferUseCase useCase) {
        this.useCase = useCase;

    }
    @Override
    public void execute(OfferDTO dto) {
        try{
            Offer domain = mapperDTOToDomain.mapToDomain(dto, Offer.class);
            useCase.execute(domain);
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}