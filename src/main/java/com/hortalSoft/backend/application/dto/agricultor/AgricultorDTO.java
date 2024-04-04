package com.hortalSoft.backend.application.dto.agricultor;

import com.hortalSoft.backend.domain.model.Asociacion;
import com.hortalSoft.backend.domain.model.TipoDocumento;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgricultorDTO {

    private long identificador;
    private TipoDocumento tipoDocumento;
    private long numeroIdentificacion;
    private String nombre;
    private String apellido;
    private long telefono;
    private String email;
    private String direccion;
    private String ciudad;
    private Asociacion asociacion;
}
