package com.hortalsoft.users.application.mapper;

import com.hortalsoft.users.application.dto.ProductDTO;
import com.hortalsoft.users.domain.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationProductMapper extends ApplicationEntityMapper<ProductDTO, Product> {
}
