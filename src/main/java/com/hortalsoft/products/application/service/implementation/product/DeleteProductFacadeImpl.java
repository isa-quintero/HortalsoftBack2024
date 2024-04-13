package com.hortalsoft.products.application.service.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.service.facade.product.DeleteProductFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeleteProductFacadeImpl implements DeleteProductFacade {
    @Override
    public ProductDTO execute(ProductDTO dto) {
        return null;
    }
}
