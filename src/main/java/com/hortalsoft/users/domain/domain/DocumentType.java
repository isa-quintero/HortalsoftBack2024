package com.hortalsoft.users.domain.domain;

import lombok.*;

import java.io.Serializable;


@Data
@RequiredArgsConstructor
public class DocumentType implements Serializable {
    private Integer idDocumentType;
    private String code;
    private String name;
    private String description;
}
