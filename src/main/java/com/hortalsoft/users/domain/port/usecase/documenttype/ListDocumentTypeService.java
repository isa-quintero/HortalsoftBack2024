package com.hortalsoft.users.domain.port.usecase.documenttype;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.domain.DocumentType;
import com.hortalsoft.users.domain.entity.DocumentTypeEntity;
import com.hortalsoft.users.domain.port.input.documenttype.ListDocumentTypeUseCase;
import com.hortalsoft.users.domain.repository.DocumentTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListDocumentTypeService implements ListDocumentTypeUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final DocumentTypeRepository documentTypeRepository;
    MapperEntityToDomain<DocumentTypeEntity, DocumentType> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListDocumentTypeService(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }


    @Override
    public List<DocumentType> execute() {
        try {
            if (documentTypeRepository.count() != 0) {
                List<DocumentTypeEntity> resultList = documentTypeRepository.findAll();
                return mapperEntityToDomain.mapToDomainList(resultList, DocumentType.class);
            } else {
                throw new ExceptionHortalsoft("No hay subcategorias para mostrar", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado listando las subcategorias", 500, layer, exception);
        }
    }
}
