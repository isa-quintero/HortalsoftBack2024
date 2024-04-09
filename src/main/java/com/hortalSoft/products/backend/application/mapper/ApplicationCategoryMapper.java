package com.hortalSoft.products.backend.application.mapper;

import com.hortalSoft.products.backend.application.dto.CategoryDTO;
import com.hortalSoft.products.backend.application.dto.ProductDTO;
import com.hortalSoft.products.backend.domain.model.Category;
import com.hortalSoft.products.backend.domain.model.Product;

//@Mapper(componentModel = "spring", uses = {})
public interface ApplicationCategoryMapper extends ApplicationEntityMapper<CategoryDTO, Category> {

}