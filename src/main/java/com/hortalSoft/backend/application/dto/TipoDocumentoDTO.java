package com.hortalSoft.backend.application.dto;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoDTO {

    private String identificador;
    private String codigo;
    private String nombre;
    private String descripcion;
}
