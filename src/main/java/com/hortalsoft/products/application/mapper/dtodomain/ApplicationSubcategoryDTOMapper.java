package com.hortalsoft.products.application.mapper.dtodomain;

import com.hortalsoft.crosscutting.response.ApplicationDTOMapper;
import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.domain.domain.Subcategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationSubcategoryDTOMapper extends ApplicationDTOMapper<SubcategoryDTO, Subcategory> {
}
