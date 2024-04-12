package com.hortalsoft.users.domain.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Farmer {
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
