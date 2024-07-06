package com.hortalsoft.users.application.facades.implementation.association;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.AssociationDTO;
import com.hortalsoft.users.application.facades.facade.association.FindAssociationIdNumberFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.port.input.association.FindAssociationIdNumberUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindAssociationFacadeIdNumberImpl implements FindAssociationIdNumberFacade {
    MapperDTOToDomain<AssociationDTO, Association> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Association, AssociationDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindAssociationIdNumberUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public FindAssociationFacadeIdNumberImpl(FindAssociationIdNumberUseCase useCase) {
        this.useCase = useCase;
    }


    @Override
    public AssociationDTO execute(AssociationDTO dto) {
        try {
            Association domain = mapperDTOToDomain.mapToDomain(dto, Association.class);
            return mapperDomainToDto.mapToDto(useCase.execute(domain), AssociationDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
