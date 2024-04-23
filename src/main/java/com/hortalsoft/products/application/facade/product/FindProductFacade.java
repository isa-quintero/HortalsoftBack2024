package com.hortalsoft.products.application.facade.product;


//import com.hortalsoft.crosscutting.response.usecase.facade.UseCaseFindFacade;
import com.hortalsoft.products.util.usecase.facade.UseCaseFindFacade;
import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.domain.domain.Product;

public interface FindProductFacade extends UseCaseFindFacade<ProductDTO> {
}
