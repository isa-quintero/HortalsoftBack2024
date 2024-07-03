package com.hortalsoft.users.domain.specification.documenttype;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.entity.DocumentTypeEntity;
import com.hortalsoft.users.domain.repository.DocumentTypeRepository;

import java.util.Objects;
import java.util.Optional;

public class DocumentTypeExistByIdSpec extends AbstractSpecification<DocumentTypeEntity> {
    private final DocumentTypeRepository documentTypeRepository;

    public DocumentTypeExistByIdSpec(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public boolean isSatisfiedBy(DocumentTypeEntity documentTypeEntity) {
        Optional<DocumentTypeEntity> existingOffer = documentTypeRepository.findById(documentTypeEntity.getIdDocumentType());
        return existingOffer.filter(entity -> Objects.equals(entity.getIdDocumentType(), documentTypeEntity.getIdDocumentType())).isPresent();
    }
}
