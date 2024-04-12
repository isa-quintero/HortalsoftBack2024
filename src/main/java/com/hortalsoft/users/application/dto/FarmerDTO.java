package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.domain.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FarmerDTO {
    private String id;
    private DocumentType documentType;
    private long idNumber;
    private String name;
    private String lastname;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
    private Association association;
}
