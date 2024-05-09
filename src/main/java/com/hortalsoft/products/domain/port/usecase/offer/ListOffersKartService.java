package com.hortalsoft.products.domain.port.usecase.offer;


import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.input.offer.ListOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layers;

import java.util.List;
import java.util.Optional;

//@Service
//@Transactional
public class ListOffersKartService implements ListOfferUseCase {

    private final OfferRepository offerRepository;
    MapperEntityToDomain<Optional<OfferEntity>, Offer> mapperEntityToDomain = new MapperEntityToDomain<>();

    public ListOffersKartService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public List<Offer> execute() {
        try{
            if (offerRepository.count() != 0) {
                Optional<OfferEntity> resultList = offerRepository.findById(1);
                return (List<Offer>) mapperEntityToDomain.mapToDomain(resultList, Offer.class);
            }else{
                throw  new ExceptionHortalsoft("No hay productos para mostrar", 6001, Layers.DOMAIN);
            }
        }
        catch(Exception e){
            if (e instanceof ExceptionHortalsoft){
                throw (ExceptionHortalsoft) e;
            }else{
                throw new ExceptionHortalsoft(e.getMessage(),500,Layers.DOMAIN);
            }
        }
    }
}
