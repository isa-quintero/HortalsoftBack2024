package com.hortalsoft.users.domain.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Association {
    private String id;
    @NonNull
    private DocumentType documentType;
    private long idNumber;
    @NonNull
    private String code;
    @NonNull
    private String name;
    private long phoneNumber;
    @NonNull
    private String email;
    @NonNull
    private String address;
    @NonNull
    private String city;
}
