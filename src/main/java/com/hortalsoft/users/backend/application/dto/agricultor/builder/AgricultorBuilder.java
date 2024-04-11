package com.hortalsoft.users.backend.application.dto.agricultor.builder;

import com.hortalsoft.users.backend.domain.model.Association;
import com.hortalsoft.users.backend.domain.model.DocumentType;

public interface AgricultorBuilder {
    AgricultorDTOBuilder setIdentificador(long identificador);
    AgricultorDTOBuilder setTipoDocumento(DocumentType documentType);
    AgricultorDTOBuilder setNombre(String nombre);
    AgricultorDTOBuilder setApellido(String apellido);
    AgricultorDTOBuilder setTelefono(long telefono);
    AgricultorDTOBuilder setEmail(String email);
    AgricultorDTOBuilder setDireccion(String direccion);
    AgricultorDTOBuilder setCiudad(String ciudad);
    AgricultorDTOBuilder setAsociacion(Association association);
}
