package com.hortalsoft.products.application.mapper;

import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.domain.domain.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationCategoryMapper extends ApplicationEntityMapper<CategoryDTO, Category>{
}
