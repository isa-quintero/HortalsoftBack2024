package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.port.input.pricerange.FindPriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.specification.implementation.pricerange.PriceRangeExistsByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindPriceRangeService implements FindPriceRangeUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final PriceRangeRepository priceRangeRepository;
    MapperDomainToEntity<PriceRange, PriceRangeEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<PriceRangeEntity, PriceRange> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindPriceRangeService(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public PriceRange execute(PriceRange domain) {
        try {
            PriceRangeExistsByIdSpec priceRangeExistsByIdSpec = new PriceRangeExistsByIdSpec(priceRangeRepository);
            PriceRangeEntity entity = mapperDomainToEntity.mapToEntity(domain, PriceRangeEntity.class);
            if (priceRangeExistsByIdSpec.isSatisfiedBy(entity)) {
                Optional<PriceRangeEntity> resultEntity = priceRangeRepository.findByFinalDateValidAndIdPriceRange(entity.getIdPriceRange());
                return mapperEntityToDomain.mapToDomain(resultEntity.get(), PriceRange.class);
            } else {
                throw new ExceptionHortalsoft("El rango de precios no existe", 6001, layer);
            }
        } catch (ExceptionHortalsoft e) {
            throw e;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el rango de precios", 500, layer, exception);
        }
    }
}
