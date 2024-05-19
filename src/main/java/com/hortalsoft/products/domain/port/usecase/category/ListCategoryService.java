package com.hortalsoft.products.domain.port.usecase.category;


import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.entity.CategoryEntity;
import com.hortalsoft.products.domain.port.input.category.ListCategoryUseCase;
import com.hortalsoft.products.domain.repository.CategoryRepository;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListCategoryService implements ListCategoryUseCase {

    private final static Layer layer = Layer.DOMAIN;
    private final CategoryRepository categoryRepository;
    MapperEntityToDomain<CategoryEntity, Category> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> execute() {
        try {
            if (categoryRepository.count() != 0) {
                List<CategoryEntity> resultList = categoryRepository.findAll();
                return mapperEntityToDomain.mapToDomainList(resultList, Category.class);
            } else {
                throw new ExceptionHortalsoft("No hay productos para mostrar", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado listando las categorias", 500, layer, exception);
        }
    }
}
