package com.hortalsoft.products.application.service.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.service.facade.product.AssociateProductFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AssociateProductFacadeImpl implements AssociateProductFacade {
    @Override
    public void execute(ProductDTO dto) {
    }
}
