package com.hortalsoft.users.domain.port.usecase.documenttype;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.domain.DocumentType;
import com.hortalsoft.users.domain.entity.DocumentTypeEntity;
import com.hortalsoft.users.domain.port.input.documenttype.FindDocumentTypeUseCase;
import com.hortalsoft.users.domain.repository.DocumentTypeRepository;
import com.hortalsoft.users.domain.specification.documenttype.DocumentTypeExistByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindDocumentTypeService implements FindDocumentTypeUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final DocumentTypeRepository documentTypeRepository;
    MapperDomainToEntity<DocumentType, DocumentTypeEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<DocumentTypeEntity, DocumentType> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindDocumentTypeService(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }


    @Override
    public DocumentType execute(DocumentType domain) {
        try {
            DocumentTypeExistByIdSpec documentTypeExistByIdSpec = new DocumentTypeExistByIdSpec(documentTypeRepository);
            DocumentTypeEntity entity = mapperDomainToEntity.mapToEntity(domain, DocumentTypeEntity.class);
            if (documentTypeExistByIdSpec.isSatisfiedBy(entity)) {
                Optional<DocumentTypeEntity> resultEntity = documentTypeRepository.findById(entity.getIdDocumentType());
                return mapperEntityToDomain.mapToDomain(resultEntity.get(), DocumentType.class);
            } else {
                throw new ExceptionHortalsoft("Tipo de documento no encontrado", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando la categoria", 500, layer, exception);
        }
    }
}
