package com.hortalsoft.products.domain.port.usecase.offer;

import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.input.offer.CreateOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateOfferService implements CreateOfferUseCase {

    private final static Layer layer = Layer.DOMAIN;
    private final OfferRepository offerRepository;
    MapperDomainToEntity<Offer, OfferEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public CreateOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void execute(Offer domain) {
        try {
            OfferEntity entity = mapperDomainToEntity.mapToEntity(domain, OfferEntity.class);
            if (offerRepository.findByProduct_IdAndInitialDateAndCodeFarmer(entity.getProduct().getId(), entity.getInitialDateOffer(), entity.getIdFarmer()) != null) {
                offerRepository.save(entity);
            } else {
                throw new ExceptionHortalsoft("La oferta ya existe", 5001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando la oferta", 500, layer, exception);
        }
    }
}
