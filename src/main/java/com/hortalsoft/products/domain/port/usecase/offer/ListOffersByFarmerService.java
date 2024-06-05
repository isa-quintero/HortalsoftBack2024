package com.hortalsoft.products.domain.port.usecase.offer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.domain.port.input.offer.ListOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.specification.implementation.offer.AvailableOffersSpec;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListOffersByFarmerService implements ListOfferUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final OfferRepository offerRepository;
    MapperEntityToDomain<OfferEntity, Offer> mapperEntityToDomain = new MapperEntityToDomain<>();

    public ListOffersByFarmerService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public List<Offer> execute(Offer domain) {
        try {
            List <OfferEntity> offers = offerRepository.findByIdFarmer(domain.getFarmerId()).stream()
                    .filter(offer -> {
                        AvailableOffersSpec availableOffersSpec = new AvailableOffersSpec(offerRepository);
                        availableOffersSpec.isSatisfiedBy(offer);
                        return availableOffersSpec.isSatisfiedBy(offer);
                    }).toList();
            return mapperEntityToDomain.mapToDomainList(offers,Offer.class);

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando la oferta", 500, layer, exception);
        }
    }
}
