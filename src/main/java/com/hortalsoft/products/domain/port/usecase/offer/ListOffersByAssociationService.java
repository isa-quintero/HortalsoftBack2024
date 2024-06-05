package com.hortalsoft.products.domain.port.usecase.offer;


import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.domain.port.input.offer.ListOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;

import java.util.List;

//@Service
//@Transactional
public class ListOffersByAssociationService implements ListOfferUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final OfferRepository offerRepository;
    MapperEntityToDomain<OfferEntity, Offer> mapperEntityToDomain = new MapperEntityToDomain<>();

    public ListOffersByAssociationService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> execute(Offer domain) {
        try {
            OfferEntity offerEntity = new OfferEntity();
            offerEntity.setIdOffer(1);
            offerEntity.setIdOffer(2);
            if (offerRepository.count() != 0) {
                List<OfferEntity> resultList = offerRepository.findByIdFarmer(offerEntity.getIdFarmer());
                return mapperEntityToDomain.mapToDomainList(resultList, Offer.class);
            } else {
                throw new ExceptionHortalsoft("No hay productos para mostrar", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado listando las ofertas por asociación", 500, layer, exception);

        }
    }

}
