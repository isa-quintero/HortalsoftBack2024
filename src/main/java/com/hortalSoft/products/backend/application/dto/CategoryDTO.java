package com.hortalSoft.products.backend.application.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private String id;
    private String name;
    private String description;
}
