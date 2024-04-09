package com.hortalSoft.products.backend.application.dto;

import com.hortalSoft.products.backend.domain.entity.CategoryEntity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryDTO {

    private String identificador;
    private String nombre;
    private String descripcion;
    private CategoryEntity categoryEntity;
}
