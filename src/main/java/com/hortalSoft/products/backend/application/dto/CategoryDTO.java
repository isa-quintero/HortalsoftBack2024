package com.hortalSoft.products.backend.application.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private String identificador;
    private String nombre;
    private String descripcion;
}
