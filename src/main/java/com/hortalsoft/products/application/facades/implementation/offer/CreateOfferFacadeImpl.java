package com.hortalsoft.products.application.facades.implementation.offer;


import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.CreateOfferFacade;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.port.input.offer.CreateOfferUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.util.ExceptionHandlingAspect;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateOfferFacadeImpl implements CreateOfferFacade {

    MapperDTOToDomain<OfferDTO, Offer> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final CreateOfferUseCase useCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public CreateOfferFacadeImpl(CreateOfferUseCase useCase, ExceptionHandlingAspect exceptionHandlingAspect){
        this.useCase = useCase;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @Override
    public void execute(OfferDTO dto) {
        try{
            Offer domain = mapperDTOToDomain.mapToDomain(dto, Offer.class);
            useCase.execute(domain);

        }catch(Exception e){
            exceptionHandlingAspect.exceptionsApplication(e);
        }
    }
}
