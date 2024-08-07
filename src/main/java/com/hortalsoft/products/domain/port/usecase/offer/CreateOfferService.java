package com.hortalsoft.products.domain.port.usecase.offer;

import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.input.offer.CreateOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.specification.implementation.offer.EmptyAttributesOfferSpec;
import com.hortalsoft.products.domain.specification.implementation.offer.ExistingOfferOverlapSpecification;
import com.hortalsoft.products.domain.specification.implementation.offer.ValidateOfferToBeCreatedSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateOfferService implements CreateOfferUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final OfferRepository offerRepository;
    MapperDomainToEntity<Offer, OfferEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public CreateOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void execute(Offer domain) {
        try {
            EmptyAttributesOfferSpec emptyAttributesOfferSpec = new EmptyAttributesOfferSpec();
            ValidateOfferToBeCreatedSpec validateOfferToBeCreatedSpec = new ValidateOfferToBeCreatedSpec();
            ExistingOfferOverlapSpecification existingOfferOverlapSpecification = new ExistingOfferOverlapSpecification(offerRepository);
            OfferEntity entity = mapperDomainToEntity.mapToEntity(domain, OfferEntity.class);
            if (!emptyAttributesOfferSpec.isSatisfiedBy(entity)){
                if (validateOfferToBeCreatedSpec.isSatisfiedBy(entity)) {
                    if (existingOfferOverlapSpecification.isSatisfiedBy(entity)) {
                        offerRepository.save(entity);
                    } else {
                        throw new ExceptionHortalsoft("La oferta ya existe", 5001, layer);
                    }
                } else {
                    throw new ExceptionHortalsoft("La oferta no cumple con las condiciones", 5001, layer);
                }
            }else{
                throw new ExceptionHortalsoft("Existen elementos vacios dentro de la oferta", 5001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando la oferta", 500, layer, exception);
        }
    }
}
