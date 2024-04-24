package com.hortalsoft.products.application.usecase.subcategory;


import com.hortalsoft.products.domain.domain.Subcategory;
import com.hortalsoft.products.domain.entity.SubcategoryEntity;
import com.hortalsoft.products.domain.port.subcategory.FindSubcategoryUseCase;
import com.hortalsoft.products.domain.repository.SubcategoryRepository;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import com.hortalsoft.products.util.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

@Service
@Transactional
public class FindSubcategoryService implements FindSubcategoryUseCase {

    private final SubcategoryRepository subcategoryRepository;
    MapperDomainToEntity<Subcategory, SubcategoryEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<SubcategoryEntity,Subcategory> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindSubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;

    }


    @Override
    public Subcategory execute(Subcategory domain) {
        try{
            SubcategoryEntity entity =  mapperDomainToEntity.mapToEntity(domain,SubcategoryEntity.class);
            Optional<SubcategoryEntity> resultEntity= subcategoryRepository.findById(entity.getId());
            if (resultEntity.isPresent()) {
                return mapperEntityToDomain.mapToDomain(resultEntity.get(),Subcategory.class);
            }
            else{
                System.out.println("La subcategoria no existe");
                return null;
            }

        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());

        }

    }
}
