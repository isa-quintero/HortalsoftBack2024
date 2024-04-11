package com.hortalsoft.users.backend.domain.model;

import lombok.*;


@Data
@Builder
@RequiredArgsConstructor
public class DocumentType {

    private long id;
    @NonNull
    private String code;
    @NonNull
    private String name;
    @NonNull
    private String description;
}
