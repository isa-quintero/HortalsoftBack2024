package com.hortalsoft.users.application.facades.implementation.association;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.AssociationDTO;
import com.hortalsoft.users.application.facades.facade.association.FindAssociationFacadeEmail;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.port.input.association.FindAssociationEmailUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindAssociationFacadeEmailImpl implements FindAssociationFacadeEmail {
    MapperDTOToDomain<AssociationDTO, Association> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Association, AssociationDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindAssociationEmailUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public FindAssociationFacadeEmailImpl(FindAssociationEmailUseCase useCase) {
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
