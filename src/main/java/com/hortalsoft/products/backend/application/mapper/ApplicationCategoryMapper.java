package com.hortalsoft.products.backend.application.mapper;

import com.hortalsoft.products.backend.application.dto.CategoryDTO;
import com.hortalsoft.products.backend.domain.domain.Category;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface ApplicationCategoryMapper extends ApplicationEntityMapper<CategoryDTO, Category> {

}