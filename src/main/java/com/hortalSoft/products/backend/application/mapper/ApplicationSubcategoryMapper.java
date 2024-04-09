package com.hortalSoft.products.backend.application.mapper;

import com.hortalSoft.products.backend.application.dto.ProductDTO;
import com.hortalSoft.products.backend.application.dto.SubcategoryDTO;
import com.hortalSoft.products.backend.domain.model.Product;
import com.hortalSoft.products.backend.domain.model.Subcategory;

//@Mapper(componentModel = "spring", uses = {})
public interface ApplicationSubcategoryMapper extends ApplicationEntityMapper<SubcategoryDTO, Subcategory> {

}