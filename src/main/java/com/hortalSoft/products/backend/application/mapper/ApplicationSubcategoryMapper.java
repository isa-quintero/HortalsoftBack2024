package com.hortalsoft.products.backend.application.mapper;


import com.hortalsoft.products.backend.application.dto.SubcategoryDTO;
import com.hortalsoft.products.backend.domain.model.Subcategory;


//@Mapper(componentModel = "spring", uses = {})
public interface ApplicationSubcategoryMapper extends ApplicationEntityMapper<SubcategoryDTO, Subcategory> {

}