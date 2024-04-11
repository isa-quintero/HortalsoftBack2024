package com.hortalsoft.products.backend.application.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryDTO {

    private String id;
    private String name;
    private String description;
    private CategoryDTO categoryDTO;
}
