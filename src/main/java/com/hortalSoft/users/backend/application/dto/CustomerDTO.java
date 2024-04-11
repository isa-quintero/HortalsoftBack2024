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
public class CustomerDTO {

    private String id;
    private DocumentType documentType;
    private long idNumber;
    private String name;
    private String lastname;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
}
