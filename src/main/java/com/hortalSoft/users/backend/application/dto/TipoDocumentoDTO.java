package com.hortalSoft.users.backend.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
