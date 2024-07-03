package com.hortalsoft.users.application.facades.implementation.documenttype;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.DocumentTypeDTO;
import com.hortalsoft.users.application.facades.facade.documenttype.FindDocumentTypeFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.DocumentType;
import com.hortalsoft.users.domain.port.input.documenttype.FindDocumentTypeUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindDocumentTypeFacadeImpl implements FindDocumentTypeFacade {
    MapperDTOToDomain<DocumentTypeDTO, DocumentType> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<DocumentType, DocumentTypeDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindDocumentTypeUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public FindDocumentTypeFacadeImpl(FindDocumentTypeUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public DocumentTypeDTO execute(DocumentTypeDTO dto) {
        try {
            DocumentType domain = mapperDTOToDomain.mapToDomain(dto, DocumentType.class);
            return mapperDomainToDto.mapToDto(useCase.execute(domain), DocumentTypeDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
