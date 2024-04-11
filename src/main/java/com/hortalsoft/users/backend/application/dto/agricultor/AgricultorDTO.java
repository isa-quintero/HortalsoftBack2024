package com.hortalsoft.users.backend.application.dto.agricultor;

import com.hortalsoft.users.backend.domain.model.Association;
import com.hortalsoft.users.backend.domain.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgricultorDTO {

    private long identificador;
    private DocumentType documentType;
    private long numeroIdentificacion;
    private String nombre;
    private String apellido;
    private long telefono;
    private String email;
    private String direccion;
    private String ciudad;
    private Association association;
}
