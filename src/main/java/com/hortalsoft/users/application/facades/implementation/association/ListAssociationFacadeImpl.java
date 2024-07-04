package com.hortalsoft.users.application.facades.implementation.association;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.AssociationDTO;
import com.hortalsoft.users.application.facades.facade.association.ListAssociationFacade;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.port.input.association.ListAssociationUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListAssociationFacadeImpl implements ListAssociationFacade {

    MapperDomainToDto<Association, AssociationDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListAssociationUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public ListAssociationFacadeImpl(ListAssociationUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<AssociationDTO> execute() {
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), AssociationDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
