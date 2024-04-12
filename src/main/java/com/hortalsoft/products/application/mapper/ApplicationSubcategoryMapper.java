package com.hortalsoft.products.application.mapper;

import com.hortalsoft.crosscutting.response.ApplicationEntityMapper;
import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.domain.domain.Subcategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationSubcategoryMapper extends ApplicationEntityMapper<SubcategoryDTO, Subcategory> {
}
