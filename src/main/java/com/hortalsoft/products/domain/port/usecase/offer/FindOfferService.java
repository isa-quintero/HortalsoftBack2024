package com.hortalsoft.products.domain.port.usecase.offer;


import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.input.offer.FindOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.specification.implementation.offer.AvailableOffersSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindOfferService implements FindOfferUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final OfferRepository offerRepository;
    MapperDomainToEntity<Offer, OfferEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<OfferEntity, Offer> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }


    @Override
    public Offer execute(Offer domain) {
        try {
            AvailableOffersSpec availableOffersSpec = new AvailableOffersSpec(offerRepository);
            OfferEntity entity = mapperDomainToEntity.mapToEntity(domain, OfferEntity.class);
            if (availableOffersSpec.isSatisfiedBy(entity)) {
                Optional<OfferEntity> resultEntity = offerRepository.findById(entity.getOfferId());
                return mapperEntityToDomain.mapToDomain(resultEntity.get(), Offer.class);
            } else {
                throw new ExceptionHortalsoft("Oferta no encontrada", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando la oferta", 500, layer, exception);
        }
    }
}
