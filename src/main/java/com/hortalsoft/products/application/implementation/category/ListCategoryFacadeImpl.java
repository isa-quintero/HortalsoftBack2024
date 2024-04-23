package com.hortalsoft.products.application.implementation.category;


import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.application.facade.category.ListCategoryFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListCategoryFacadeImpl implements ListCategoryFacade {
    @Override
    public List<CategoryDTO> execute(Optional<CategoryDTO> dto) {
        return List.of();
    }
}
