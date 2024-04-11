package com.hortalsoft.users.backend.domain.model;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
public class Farmer {

    private long id;
    private DocumentType documentType;


    private long idNumber;
    @NonNull
    private String name;
    @NonNull
    private String lastname;
    private long phoneNumber;
    @NonNull
    private String email;
    @NonNull
    private String address;
    @NonNull
    private String city;

    @NonNull
    private Association association;

}
