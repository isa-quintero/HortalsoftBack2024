package com.hortalsoft.products.application.facades.implementation.category;


import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.application.facades.facade.category.FindCategoryFacade;
import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.port.input.category.FindCategoryUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindCategoryFacadeImpl implements FindCategoryFacade {
    MapperDTOToDomain<CategoryDTO, Category> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Category, CategoryDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindCategoryUseCase useCase;

    public FindCategoryFacadeImpl(FindCategoryUseCase useCase) {
        this.useCase = useCase;
    }
    @Override
    public CategoryDTO execute(CategoryDTO dto) {
        Category domain = mapperDTOToDomain.mapToDomain(dto,Category.class);
        return mapperDomainToDto.mapToDto(useCase.execute(domain),CategoryDTO.class);
    }
}