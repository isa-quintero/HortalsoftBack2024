package com.hortalsoft.products.domain.port.product;

import com.hortalsoft.crosscutting.response.usecase.domain.UseCaseFindDomain;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;

public interface FindProductUseCase extends UseCaseFindDomain<Product> {
}
