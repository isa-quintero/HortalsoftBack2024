package com.hortalSoft.backend.application.dto.agricultor.builder;

import com.hortalSoft.backend.domain.model.Asociacion;
import com.hortalSoft.backend.domain.model.TipoDocumento;

public interface AgricultorBuilder {
    AgricultorDTOBuilder setIdentificador(long identificador);
    AgricultorDTOBuilder setTipoDocumento(TipoDocumento tipoDocumento);
    AgricultorDTOBuilder setNombre(String nombre);
    AgricultorDTOBuilder setApellido(String apellido);
    AgricultorDTOBuilder setTelefono(long telefono);
    AgricultorDTOBuilder setEmail(String email);
    AgricultorDTOBuilder setDireccion(String direccion);
    AgricultorDTOBuilder setCiudad(String ciudad);
    AgricultorDTOBuilder setAsociacion(Asociacion asociacion);
}
