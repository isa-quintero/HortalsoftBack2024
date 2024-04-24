package com.hortalsoft.products.application.usecase.subcategory;


import com.hortalsoft.products.domain.domain.Subcategory;
import com.hortalsoft.products.domain.entity.SubcategoryEntity;
import com.hortalsoft.products.domain.port.subcategory.ListSubcategoryUseCase;
import com.hortalsoft.products.domain.repository.SubcategoryRepository;
import com.hortalsoft.products.util.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;

@Service
@Transactional
public class ListSubcategoryService implements ListSubcategoryUseCase {

    private final SubcategoryRepository subcategoryRepository;
    MapperEntityToDomain<SubcategoryEntity, Subcategory> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListSubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }


    @Override
    public List<Subcategory> execute() {
        try{
            List<SubcategoryEntity> resultList = subcategoryRepository.findAll();
            return mapperEntityToDomain.mapToDomainList(resultList,Subcategory.class);
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}
