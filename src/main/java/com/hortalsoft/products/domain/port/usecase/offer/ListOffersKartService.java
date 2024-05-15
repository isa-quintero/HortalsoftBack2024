package com.hortalsoft.products.domain.port.usecase.offer;


import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.input.offer.ListOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;

import java.util.List;
import java.util.Optional;

//@Service
//@Transactional
public class ListOffersKartService implements ListOfferUseCase {

    private final static Layer layer = Layer.DOMAIN
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
                throw  new ExceptionHortalsoft("No hay productos para mostrar", 6001, layer);
            }
        }
        catch(ExceptionHortalsoft exceptionHortalsoft){
            throw exceptionHortalsoft;
        }catch (Exception exception){
            throw new ExceptionHortalsoft("Ha ocurrido un error",500, layer);
        }
    }
}
