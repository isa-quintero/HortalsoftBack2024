package com.hortalsoft.products.application.facades.implementation.category;


import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.application.facades.facade.category.FindCategoryFacade;
import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.port.input.category.FindCategoryUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layers;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindCategoryFacadeImpl implements FindCategoryFacade {
    MapperDTOToDomain<CategoryDTO, Category> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Category, CategoryDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindCategoryUseCase useCase;
    private final Layers layer = Layers.APPLICATION;


    public FindCategoryFacadeImpl(FindCategoryUseCase useCase) {
        this.useCase = useCase;
    }
    /**
     * Executes the FindCategoryFacadeImpl method.
     *
     * @param dto The CategoryDTO object to be executed.
     * @return The CategoryDTO object after execution.
     * @throws ExceptionHortalsoft If any exception occurs during the execution.
     */

    @Override
    public CategoryDTO execute(CategoryDTO dto) {
        try {
            Category domain = mapperDTOToDomain.mapToDomain(dto, Category.class);
            return mapperDomainToDto.mapToDto(useCase.execute(domain), CategoryDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error", 500, layer, exception);
        }
    }
}
