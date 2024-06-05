package com.hortalsoft.products.domain.port.usecase.category;

import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.entity.CategoryEntity;
import com.hortalsoft.products.domain.port.input.category.FindCategoryUseCase;
import com.hortalsoft.products.domain.repository.CategoryRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.specification.implementation.category.CategoryExistByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindCategoryService implements FindCategoryUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final CategoryRepository categoryRepository;
    MapperDomainToEntity<Category, CategoryEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<CategoryEntity, Category> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }


    @Override
    public Category execute(Category domain) {
        try {
            CategoryExistByIdSpec categoryExistByIdSpec = new CategoryExistByIdSpec(categoryRepository);
            CategoryEntity entity = mapperDomainToEntity.mapToEntity(domain, CategoryEntity.class);
            if (categoryExistByIdSpec.isSatisfiedBy(entity)) {
                Optional<CategoryEntity> resultEntity = categoryRepository.findById(entity.getId());
                return mapperEntityToDomain.mapToDomain(resultEntity.get(), Category.class);
            } else {
                throw new ExceptionHortalsoft("Categoria no encontrada", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando la categoria", 500, layer, exception);
        }
    }
}
