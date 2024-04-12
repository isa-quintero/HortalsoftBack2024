package com.hortalsoft.products.application.mapper.dtodomain;

import com.hortalsoft.crosscutting.response.ApplicationDTOMapper;
import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.domain.domain.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationCategoryDTOMapper extends ApplicationDTOMapper<CategoryDTO, Category> {
}
