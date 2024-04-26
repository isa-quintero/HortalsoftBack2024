package com.hortalsoft.products.domain.port.usecase.category;


import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.entity.CategoryEntity;
import com.hortalsoft.products.domain.port.input.category.ListCategoryUseCase;
import com.hortalsoft.products.domain.repository.CategoryRepository;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;

@Service
@Transactional
public class ListCategoryService implements ListCategoryUseCase {

    private final CategoryRepository categoryRepository;
    MapperEntityToDomain<CategoryEntity,Category> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> execute() {
        try{
            List<CategoryEntity> resultList = categoryRepository.findAll();
            return mapperEntityToDomain.mapToDomainList(resultList,Category.class);
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}
