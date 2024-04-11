package com.hortalSoft.users.backend.application.dto;

import com.hortalSoft.users.backend.domain.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssociationDTO {

    private String id;
    private DocumentType documentType;
    private int idNumber;
    private String code;
    private String name;
    private  int phoneNumber;
    private String email;
    private String address;
    private String city;
}
