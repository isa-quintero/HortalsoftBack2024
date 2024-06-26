package com.hortalsoft.products.domain.port.usecase.offer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.domain.port.input.offer.ListOffersUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListOffersService implements ListOffersUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final OfferRepository offerRepository;
    MapperEntityToDomain<OfferEntity, Offer> mapperEntityToDomain = new MapperEntityToDomain<>();

    public ListOffersService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public List<Offer> execute() {
        try {
            if (offerRepository.count() != 0) {
                List<OfferEntity> resultList = offerRepository.findAll();
                return mapperEntityToDomain.mapToDomainList(resultList, Offer.class);
            } else {
                throw new ExceptionHortalsoft("No hay ofertas para mostrar", 6001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft(exception.getMessage(), 500, layer, exception);
        }
    }
}
