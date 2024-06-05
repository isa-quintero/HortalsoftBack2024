package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.port.input.pricerange.CreatePriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.specification.implementation.pricerange.UniquePriceRangeByAssociatioAndProductAndDateSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreatePriceRangeService implements CreatePriceRangeUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final PriceRangeRepository priceRangeRepository;
    MapperDomainToEntity<PriceRange, PriceRangeEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    @Autowired
    public CreatePriceRangeService(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public void execute(PriceRange domain) {
        try {
            UniquePriceRangeByAssociatioAndProductAndDateSpec uniquePriceRangeByAssociatioAndProductAndDateSpec = new UniquePriceRangeByAssociatioAndProductAndDateSpec(priceRangeRepository);
            PriceRangeEntity entity = mapperDomainToEntity.mapToEntity(domain, PriceRangeEntity.class);
            if (!uniquePriceRangeByAssociatioAndProductAndDateSpec.isSatisfiedBy(entity)) {
                priceRangeRepository.save(entity);
            } else {
                throw new ExceptionHortalsoft("El rango de precios ya existe", 5001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando el rango de precios", 500, layer, exception);
        }
    }
}
