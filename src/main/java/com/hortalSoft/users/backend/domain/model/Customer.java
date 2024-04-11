package com.hortalsoft.users.backend.domain.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
public class Customer implements Serializable {

    private String id;
    //private DocumentType documentType;
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
}
