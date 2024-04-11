package com.hortalsoft.transactions.application.mapper;

import com.hortalsoft.transactions.application.dto.ProductDTO;
import com.hortalsoft.transactions.domain.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationProductMapper extends ApplicationEntityMapper<ProductDTO, Product> {
}
