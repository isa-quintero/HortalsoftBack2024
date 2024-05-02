package com.hortalsoft.products.domain.port.usecase.category;


import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.entity.CategoryEntity;
import com.hortalsoft.products.domain.port.input.category.FindCategoryUseCase;
import com.hortalsoft.products.domain.repository.CategoryRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import com.hortalsoft.products.util.Layers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindCategoryService implements FindCategoryUseCase {

    private final CategoryRepository categoryRepository;
    MapperDomainToEntity<Category, CategoryEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<CategoryEntity,Category> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }


    @Override
    public Category execute(Category domain) {
        try{
            CategoryEntity entity =  mapperDomainToEntity.mapToEntity(domain,CategoryEntity.class);
            Optional<CategoryEntity> resultEntity= categoryRepository.findById(entity.getId());
            if (resultEntity.isPresent()) {
                return mapperEntityToDomain.mapToDomain(resultEntity.get(),Category.class);
            }
            else{
                throw  new ExceptionHortalsoft("Categoria no encontrada", 6001, Layers.DOMAIN);
            }
        }
        catch(Exception e){
            if (e instanceof ExceptionHortalsoft){
                throw (ExceptionHortalsoft) e;
            }else{
                throw new ExceptionHortalsoft(e.getMessage(),500,Layers.DOMAIN);
            }
        }
    }
}
