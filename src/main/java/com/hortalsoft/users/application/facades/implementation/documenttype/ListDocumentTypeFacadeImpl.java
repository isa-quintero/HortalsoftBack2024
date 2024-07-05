package com.hortalsoft.users.application.facades.implementation.documenttype;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.DocumentTypeDTO;
import com.hortalsoft.users.application.facades.facade.documenttype.ListDocumentTypeFacade;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.DocumentType;
import com.hortalsoft.users.domain.port.input.documenttype.ListDocumentTypeUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListDocumentTypeFacadeImpl implements ListDocumentTypeFacade {

    MapperDomainToDto<DocumentType, DocumentTypeDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListDocumentTypeUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public ListDocumentTypeFacadeImpl(ListDocumentTypeUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<DocumentTypeDTO> execute() {
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), DocumentTypeDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
