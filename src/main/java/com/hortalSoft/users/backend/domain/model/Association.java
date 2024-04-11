package com.hortalsoft.users.backend.domain.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
public class Association implements Serializable {

    private String id;
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
