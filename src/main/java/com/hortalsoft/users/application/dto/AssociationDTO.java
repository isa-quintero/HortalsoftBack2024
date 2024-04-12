package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.domain.domain.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssociationDTO {
    private String id;
    private DocumentType documentType;
    private long idNumber;
    private String code;
    private String name;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
}
