package com.hortalSoft.backend.application.dto;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetodoEntregaDTO {

    private String identificador;
    private String nombre;
    private String descripcion;
}
