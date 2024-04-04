package com.hortalSoft.backend.application.dto;

import com.hortalSoft.backend.domain.model.Departamento;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CiudadDTO {

    private String identificador;
    private String nombre;
    private Departamento departamento;
    private boolean estado;
}
