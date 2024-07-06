package com.hortalsoft.products.domain.port.usecase.offer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.domain.port.input.offer.ListOfferByFarmerUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.specification.implementation.offer.OfferExistByFarmerSpec;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListOffersByFarmerService implements ListOfferByFarmerUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final OfferRepository offerRepository;
    MapperEntityToDomain<OfferEntity, Offer> mapperEntityToDomain = new MapperEntityToDomain<>();
    MapperDomainToEntity<Offer, OfferEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    public ListOffersByFarmerService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public List<Offer> execute(Offer domain) {
        try {
            OfferExistByFarmerSpec offerExistByFarmerSpec = new OfferExistByFarmerSpec(offerRepository);
            OfferEntity entity = mapperDomainToEntity.mapToEntity(domain, OfferEntity.class);
            if (!offerExistByFarmerSpec.isSatisfiedBy(entity)){
                List<OfferEntity> resultList = offerRepository.findByFarmer(entity.getFarmer());
                return mapperEntityToDomain.mapToDomainList(resultList, Offer.class);
            } else {
                throw new ExceptionHortalsoft("No tiene ofertas disponibles", 6001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando la oferta", 500, layer, exception);
        }
    }
}
