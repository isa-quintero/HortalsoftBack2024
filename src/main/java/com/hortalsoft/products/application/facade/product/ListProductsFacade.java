package com.hortalsoft.products.application.facade.product;


//import com.hortalsoft.crosscutting.response.usecase.facade.UseCaseListFacade;
import com.hortalsoft.products.util.usecase.facade.UseCaseListFacade;
import com.hortalsoft.products.application.dto.ProductDTO;

import java.util.List;

public interface ListProductsFacade extends UseCaseListFacade<ProductDTO> {
}
