package com.hortalSoft.backend.application.dto.producto.builder;

import com.hortalSoft.backend.domain.model.Asociacion;
import com.hortalSoft.backend.domain.model.TipoDocumento;

public class ProductoDTOBuilder implements ProductoBuilder {
    public static ProductoDTOBuilder getAgricultorDTOBuilder(){
        return new ProductoDTOBuilder();
    }
    @Override
    public ProductoDTOBuilder setIdentificador(long identificador) {
        return null;
    }

    @Override
    public ProductoDTOBuilder setTipoDocumento(TipoDocumento tipoDocumento) {
        return null;
    }

    @Override
    public ProductoDTOBuilder setNombre(String nombre) {
        return null;
    }

    @Override
    public ProductoDTOBuilder setApellido(String apellido) {
        return null;
    }

    @Override
    public ProductoDTOBuilder setTelefono(long telefono) {
        return null;
    }

    @Override
    public ProductoDTOBuilder setEmail(String email) {
        return null;
    }

    @Override
    public ProductoDTOBuilder setDireccion(String direccion) {
        return null;
    }

    @Override
    public ProductoDTOBuilder setCiudad(String ciudad) {
        return null;
    }

    @Override
    public ProductoDTOBuilder setAsociacion(Asociacion asociacion) {
        return null;
    }
}
