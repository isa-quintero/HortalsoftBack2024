package com.hortalsoft.products.application.service.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.service.facade.product.ModifyProductFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ModifyProductFacadeImpl implements ModifyProductFacade {
    @Override
    public ProductDTO execute(ProductDTO dto) {
        return null;
    }
}
