package com.hortalSoft.users.backend.application.dto.farmer.builder;

import com.hortalSoft.users.backend.domain.model.Association;
import com.hortalSoft.users.backend.domain.model.DocumentType;

public interface FarmerBuilder {
    FarmerDTOBuilder setId(long id);
    FarmerDTOBuilder setDocumentType(DocumentType documentType);
    FarmerDTOBuilder setName(String name);
    FarmerDTOBuilder setLastname(String lastname);
    FarmerDTOBuilder setPhoneNumber(long phoneNumber);
    FarmerDTOBuilder setEmail(String email);
    FarmerDTOBuilder setAddress(String address);
    FarmerDTOBuilder setCity(String city);
    FarmerDTOBuilder setAssociation(Association association);
}

