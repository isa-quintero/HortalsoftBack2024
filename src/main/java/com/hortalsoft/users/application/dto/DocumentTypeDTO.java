package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.domain.domain.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentTypeDTO {
    private String id;
    private String code;
    private String name;
    private String description;
}
