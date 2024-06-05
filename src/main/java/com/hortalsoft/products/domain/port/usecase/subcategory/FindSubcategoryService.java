package com.hortalsoft.products.domain.port.usecase.subcategory;


import com.hortalsoft.products.domain.domain.Subcategory;
import com.hortalsoft.products.domain.entity.SubcategoryEntity;
import com.hortalsoft.products.domain.port.input.subcategory.FindSubcategoryUseCase;
import com.hortalsoft.products.domain.repository.SubcategoryRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.specification.implementation.subcategory.SubcategoryExistByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindSubcategoryService implements FindSubcategoryUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final SubcategoryRepository subcategoryRepository;
    MapperDomainToEntity<Subcategory, SubcategoryEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<SubcategoryEntity, Subcategory> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindSubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }


    @Override
    public Subcategory execute(Subcategory domain) {
        try {
            SubcategoryExistByIdSpec subcategoryExistByIdSpec = new SubcategoryExistByIdSpec(subcategoryRepository);
            SubcategoryEntity entity = mapperDomainToEntity.mapToEntity(domain, SubcategoryEntity.class);
            if (subcategoryExistByIdSpec.isSatisfiedBy(entity)) {
                Optional<SubcategoryEntity> resultEntity = subcategoryRepository.findById(entity.getId());
                return mapperEntityToDomain.mapToDomain(resultEntity.get(), Subcategory.class);
            } else {
                throw new ExceptionHortalsoft("Subcategoria no encontrado", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando la categoria", 500, layer, exception);
        }
    }
}
