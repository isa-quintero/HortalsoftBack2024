package com.hortalSoft.products.backend.application.mapper;

import com.hortalSoft.products.backend.application.dto.CategoryDTO;
import com.hortalSoft.products.backend.domain.model.Category;

//@Mapper(componentModel = "spring", uses = {})
public interface ApplicationCategoryMapper extends ApplicationEntityMapper<CategoryDTO, Category> {

}