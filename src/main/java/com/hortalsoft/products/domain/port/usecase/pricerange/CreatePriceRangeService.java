package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.port.input.pricerange.CreatePriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.specification.implementation.pricerange.EmptyProductOrAssociationPriceRangeSpec;
import com.hortalsoft.products.domain.specification.implementation.pricerange.UniquePriceRangeByAssociatioAndProductAndDateSpec;
import com.hortalsoft.products.domain.specification.implementation.pricerange.ValidatePriceAndDatePriceRangeSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreatePriceRangeService implements CreatePriceRangeUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final PriceRangeRepository priceRangeRepository;
    MapperDomainToEntity<PriceRange, PriceRangeEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    private static final Logger logger = LoggerFactory.getLogger(CreatePriceRangeService.class);

    @Autowired
    public CreatePriceRangeService(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public void execute(PriceRange domain) {
        try {
            logger.info("Iniciando la creación del rango de precios...");
            EmptyProductOrAssociationPriceRangeSpec productOrAssociationPriceRangeSpec = new EmptyProductOrAssociationPriceRangeSpec();
            UniquePriceRangeByAssociatioAndProductAndDateSpec uniquePriceRangeByAssociatioAndProductAndDateSpec = new UniquePriceRangeByAssociatioAndProductAndDateSpec(priceRangeRepository);
            ValidatePriceAndDatePriceRangeSpec validatePriceAndDatePriceRangeSpec = new ValidatePriceAndDatePriceRangeSpec();
            PriceRangeEntity entity = mapperDomainToEntity.mapToEntity(domain, PriceRangeEntity.class);
            if(!productOrAssociationPriceRangeSpec.isSatisfiedBy((entity))){
                if (uniquePriceRangeByAssociatioAndProductAndDateSpec.isSatisfiedBy(entity)) {
                    if (!validatePriceAndDatePriceRangeSpec.isSatisfiedBy(entity)){
                        priceRangeRepository.save(entity);
                    } else {
                        throw new ExceptionHortalsoft("El rango de precios no esta vigente", 5001, layer);
                    }
                } else {
                    throw new ExceptionHortalsoft("El rango de precios ya existe", 5001, layer);
                }
            } else{
                throw new ExceptionHortalsoft("La asociación o el producto del rango de precios estan vacios", 5001, layer);
            }

        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando el rango de precios", 500, layer, exception);
        }
    }
}
