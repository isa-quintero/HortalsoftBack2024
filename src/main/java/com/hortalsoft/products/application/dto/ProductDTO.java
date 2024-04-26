package com.hortalsoft.products.application.dto;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private long id;
    private String name;
    private long codeSubcategory;
    //private SubcategoryDTO subcategoryDto;
}
