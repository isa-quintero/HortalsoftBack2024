package com.hortalSoft.products.backend.application.mapper;

import com.hortalSoft.products.backend.application.dto.ProductDTO;
import com.hortalSoft.products.backend.domain.model.Product;

//@Mapper(componentModel = "spring", uses = {})
public interface ApplicationProductMapper extends ApplicationEntityMapper<ProductDTO, Product> {

}