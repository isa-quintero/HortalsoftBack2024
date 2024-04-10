package com.hortalSoft.users.backend.application.dto.agricultor.builder;

import com.hortalSoft.users.backend.domain.model.Association;
import com.hortalSoft.users.backend.domain.model.DocumentType;

public class AgricultorDTOBuilder implements AgricultorBuilder {
    public static AgricultorDTOBuilder getAgricultorDTOBuilder(){
        return new AgricultorDTOBuilder();
    }
    @Override
    public AgricultorDTOBuilder setIdentificador(long identificador) {
        return null;
    }

    @Override
    public AgricultorDTOBuilder setTipoDocumento(DocumentType documentType) {
        return null;
    }

    @Override
    public AgricultorDTOBuilder setNombre(String nombre) {
        return null;
    }

    @Override
    public AgricultorDTOBuilder setApellido(String apellido) {
        return null;
    }

    @Override
    public AgricultorDTOBuilder setTelefono(long telefono) {
        return null;
    }

    @Override
    public AgricultorDTOBuilder setEmail(String email) {
        return null;
    }

    @Override
    public AgricultorDTOBuilder setDireccion(String direccion) {
        return null;
    }

    @Override
    public AgricultorDTOBuilder setCiudad(String ciudad) {
        return null;
    }

    @Override
    public AgricultorDTOBuilder setAsociacion(Association association) {
        return null;
    }
}
