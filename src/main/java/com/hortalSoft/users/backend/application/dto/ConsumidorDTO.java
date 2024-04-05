package com.hortalSoft.users.backend.application.dto;

import com.hortalSoft.users.backend.domain.model.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsumidorDTO {

    private String identificador;
    private TipoDocumento tipoDocumento;
    private long numeroIdentificacion;
    private String nombre;
    private String apellido;
    private long telefono;
    private String email;
    private String direccion;
    private String ciudad;
}
