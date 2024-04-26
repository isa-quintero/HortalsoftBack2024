package com.hortalsoft.products.application.facades.implementation.offer;



import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.FindOfferFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.port.input.offer.FindOfferUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindOfferFacadeImpl implements FindOfferFacade {
    MapperDTOToDomain<OfferDTO, Offer> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Offer, OfferDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindOfferUseCase useCase;

    public FindOfferFacadeImpl(FindOfferUseCase useCase) {
        this.useCase = useCase;
    }
    @Override
    public OfferDTO execute(OfferDTO dto) {
        Offer domain = mapperDTOToDomain.mapToDomain(dto,Offer.class);
        return mapperDomainToDto.mapToDto(useCase.execute(domain),OfferDTO.class);

    }
}