package com.hortalsoft.users.backend.application.dto;

import com.hortalsoft.users.backend.domain.model.DocumentType;
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
    private DocumentType documentType;
    private long numeroIdentificacion;
    private String nombre;
    private String apellido;
    private long telefono;
    private String email;
    private String direccion;
    private String ciudad;
}
