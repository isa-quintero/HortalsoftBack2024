package com.hortalsoft.products.application.facades.implementation.subcategory;


import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.application.facades.facade.subcategory.FindSubcategoryFacade;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Subcategory;
import com.hortalsoft.products.domain.port.input.subcategory.FindSubcategoryUseCase;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindSubcategoryFacadeImpl implements FindSubcategoryFacade {
    MapperDTOToDomain<SubcategoryDTO, Subcategory> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Subcategory, SubcategoryDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindSubcategoryUseCase useCase;

    public FindSubcategoryFacadeImpl(FindSubcategoryUseCase useCase) {
        this.useCase = useCase;
    }


    @Override
    public SubcategoryDTO execute(SubcategoryDTO dto) {
        try{
            Subcategory domain = mapperDTOToDomain.mapToDomain(dto,Subcategory.class);
            return mapperDomainToDto.mapToDto(useCase.execute(domain),SubcategoryDTO.class);
        } catch(Exception e){
            if (e instanceof ExceptionHortalsoft){
                throw (ExceptionHortalsoft) e;
            }else{
                throw new ExceptionHortalsoft(e.getMessage(),500,"Application");
            }
        }

    }
}
