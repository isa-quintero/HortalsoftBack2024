package com.hortalSoft.backend.application.dto;

import com.hortalSoft.backend.domain.model.TipoDocumento;
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
    private TipoDocumento tipoDocumento;
    private int numeroIdentificacion;
    private String codigo;
    private String nombre;
    private  int telefono;
    private String email;
    private String direccion;
    private String ciudad;
}
