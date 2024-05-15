package com.hortalsoft.products.application.facades.implementation.category;


import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.application.facades.facade.category.ListCategoryFacade;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.port.input.category.ListCategoryUseCase;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListCategoryFacadeImpl implements ListCategoryFacade {
    MapperDomainToDto<Category, CategoryDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListCategoryUseCase useCase;
    private final Layers layer = Layers.APPLICATION;


    public ListCategoryFacadeImpl(ListCategoryUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the list category operation.
     *
     * @return a list of CategoryDTO objects representing the categories.
     * @throws ExceptionHortalsoft if an ExceptionHortalsoft occurs during the execution.
     */
    @Override
    public List<CategoryDTO> execute() {
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), CategoryDTO.class);
        }catch(ExceptionHortalsoft exceptionHortalsoft){
            throw exceptionHortalsoft;
        }catch(Exception exception){
            throw new ExceptionHortalsoft("Ha ocurrido un error al listar las categorias",500, layer,exception);
        }
    }
}
