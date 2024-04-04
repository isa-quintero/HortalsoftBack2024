package com.hortalSoft.backend.application.dto;

import com.hortalSoft.backend.domain.model.Categoria;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
