package com.hortalsoft.products.domain.port.usecase.category;


import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.entity.CategoryEntity;
import com.hortalsoft.products.domain.port.input.category.FindCategoryUseCase;
import com.hortalsoft.products.domain.repository.CategoryRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

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
                System.out.println("La categoria no existe");
                return null;
            }

        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());

        }

    }
}
