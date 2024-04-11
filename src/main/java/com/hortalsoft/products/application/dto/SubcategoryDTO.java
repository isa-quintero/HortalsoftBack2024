package com.hortalsoft.products.application.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryDTO {
    private long id;
    private String name;
    private String description;
    private CategoryDTO categoryDTO;
    private List<ProductDTO> productDTO;
}
