package com.hortalsoft.users.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DocumentType {
    private String id;
    private String code;
    private String name;
    private String description;

}
