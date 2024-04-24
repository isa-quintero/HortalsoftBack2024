package com.hortalsoft.products.application.dto;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryDTO {
    private long id;
    private String name;
    private String description;
    //TODO eliminar codeCategory y descomentar
    private long codeCategory;
    //private CategoryDTO categoryDTO;
}
