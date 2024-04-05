package com.hortalSoft.products.backend.application.dto;

import com.hortalSoft.products.backend.domain.model.Categoria;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoriaDTO {

    private String identificador;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
}
