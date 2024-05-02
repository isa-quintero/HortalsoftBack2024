package com.hortalsoft.products.domain.port.usecase.subcategory;


import com.hortalsoft.products.domain.domain.Subcategory;
import com.hortalsoft.products.domain.entity.SubcategoryEntity;
import com.hortalsoft.products.domain.port.input.subcategory.FindSubcategoryUseCase;
import com.hortalsoft.products.domain.repository.SubcategoryRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.util.ExceptionHortalsoft;
import com.hortalsoft.util.Layers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                throw  new ExceptionHortalsoft("Subcategoria no encontrado", 6001, Layers.DOMAIN);
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
