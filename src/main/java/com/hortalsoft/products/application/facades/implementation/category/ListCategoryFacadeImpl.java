package com.hortalsoft.products.application.facades.implementation.category;


import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.application.facades.facade.category.ListCategoryFacade;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.port.input.category.ListCategoryUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListCategoryFacadeImpl implements ListCategoryFacade {
    MapperDomainToDto<Category, CategoryDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListCategoryUseCase useCase;

    public ListCategoryFacadeImpl(ListCategoryUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<CategoryDTO> execute() {
        return mapperDomainToDto.mapToDtoList(useCase.execute(),CategoryDTO.class);
    }
}