package com.hortalsoft.products.application.facades.implementation.offer;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.CreateOfferFacade;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.port.input.offer.CreateOfferUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateOfferFacadeImpl implements CreateOfferFacade {

    MapperDTOToDomain<OfferDTO, Offer> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final CreateOfferUseCase useCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public CreateOfferFacadeImpl(CreateOfferUseCase useCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.useCase = useCase;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    /**
     * Executes the CreateOfferFacadeImpl by validating the OfferDTO and mapping it to the Offer domain object.
     *
     * @param dto The OfferDTO object to be executed.
     * @throws ValidationException If the Product ID or Farmer ID in the OfferDTO is null.
     */
    @Override
    public void execute(OfferDTO dto) {
        validateOfferDTO(dto);

        try {
            Offer domain = mapperDTOToDomain.mapToDomain(dto, Offer.class);
            useCase.execute(domain);

        } catch (Exception exception) {
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }

    private void validateOfferDTO(OfferDTO dto) {
        if (dto.getProductId() == null) {
            throw new ValidationException("Producto ID no puede ser nulo");
        }
        if (dto.getFarmer() == null) {
            throw new ValidationException("Agricultor ID no puede ser nulo");
        }
    }
}
