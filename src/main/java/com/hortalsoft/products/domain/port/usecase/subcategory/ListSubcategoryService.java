package com.hortalsoft.products.domain.port.usecase.subcategory;


import com.hortalsoft.products.domain.domain.Subcategory;
import com.hortalsoft.products.domain.entity.SubcategoryEntity;
import com.hortalsoft.products.domain.port.input.subcategory.ListSubcategoryUseCase;
import com.hortalsoft.products.domain.repository.SubcategoryRepository;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            if (subcategoryRepository.count() != 0) {
                List<SubcategoryEntity> resultList = subcategoryRepository.findAll();
                return mapperEntityToDomain.mapToDomainList(resultList, Subcategory.class);
            }else{
                throw  new ExceptionHortalsoft("No hay subcategorias para mostrar", 6001, Layer.DOMAIN);
            }
        }
        catch(Exception e){
            if (e instanceof ExceptionHortalsoft){
                throw (ExceptionHortalsoft) e;
            }else{
                throw new ExceptionHortalsoft(e.getMessage(),500, Layer.DOMAIN);
            }
        }
    }
}
