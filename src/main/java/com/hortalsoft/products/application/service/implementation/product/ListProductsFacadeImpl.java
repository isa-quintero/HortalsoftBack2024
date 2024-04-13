package com.hortalsoft.products.application.service.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.service.facade.product.ListProductsFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListProductsFacadeImpl implements ListProductsFacade {
    @Override
    public List<ProductDTO> execute(Optional<ProductDTO> dto) {
        return List.of();
    }
}
