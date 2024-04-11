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
public class AsociacionDTO {

    private String identificador;
    private DocumentType documentType;
    private int numeroIdentificacion;
    private String codigo;
    private String nombre;
    private  int telefono;
    private String email;
    private String direccion;
    private String ciudad;
}
