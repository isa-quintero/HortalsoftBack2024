package com.hortalsoft.products.application.facades.implementation.subcategory;


import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.application.facades.facade.subcategory.ListSubcategoryFacade;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Subcategory;
import com.hortalsoft.products.domain.port.input.subcategory.ListSubcategoryUseCase;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListSubcategoryFacadeImpl implements ListSubcategoryFacade {

    MapperDomainToDto<Subcategory, SubcategoryDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListSubcategoryUseCase useCase;
    private final Layer layer = Layer.APPLICATION;

    public ListSubcategoryFacadeImpl(ListSubcategoryUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the list subcategory use case and maps the resulting domain objects to DTOs.
     *
     * @return a list of SubcategoryDTO objects representing the subcategories
     * @throws ExceptionHortalsoft if an ExceptionHortalsoft is thrown during the execution
     */
    @Override
    public List<SubcategoryDTO> execute() {
        try{
            return mapperDomainToDto.mapToDtoList(useCase.execute(), SubcategoryDTO.class);
        }catch(ExceptionHortalsoft exceptionHortalsoft){
            throw exceptionHortalsoft;
        }catch(Exception exception){
            throw new ExceptionHortalsoft("Ha ocurrido un error",500, layer, exception);
        }

    }
}
