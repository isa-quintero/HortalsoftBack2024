package com.hortalSoft.backend.application.dto.oferta.builder;

import com.hortalSoft.backend.domain.model.Asociacion;
import com.hortalSoft.backend.domain.model.TipoDocumento;

public class OfertaDTOBuilder implements OfertaBuilder {
    public static OfertaDTOBuilder getAgricultorDTOBuilder(){
        return new OfertaDTOBuilder();
    }
    @Override
    public OfertaDTOBuilder setIdentificador(long identificador) {
        return null;
    }

    @Override
    public OfertaDTOBuilder setTipoDocumento(TipoDocumento tipoDocumento) {
        return null;
    }

    @Override
    public OfertaDTOBuilder setNombre(String nombre) {
        return null;
    }

    @Override
    public OfertaDTOBuilder setApellido(String apellido) {
        return null;
    }

    @Override
    public OfertaDTOBuilder setTelefono(long telefono) {
        return null;
    }

    @Override
    public OfertaDTOBuilder setEmail(String email) {
        return null;
    }

    @Override
    public OfertaDTOBuilder setDireccion(String direccion) {
        return null;
    }

    @Override
    public OfertaDTOBuilder setCiudad(String ciudad) {
        return null;
    }

    @Override
    public OfertaDTOBuilder setAsociacion(Asociacion asociacion) {
        return null;
    }
}
