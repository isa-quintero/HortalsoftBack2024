package com.hortalsoft.products.application.service.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.service.facade.product.FindProductFacade;
import com.hortalsoft.products.domain.domain.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindProductFacadeImpl implements FindProductFacade {
    @Override
    public Product execute(ProductDTO dto) {
        return null;
    }
}
