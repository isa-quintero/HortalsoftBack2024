package com.hortalSoft.backend.application.dto.producto.builder;

import com.hortalSoft.backend.domain.model.Asociacion;
import com.hortalSoft.backend.domain.model.TipoDocumento;

public interface ProductoBuilder {
    ProductoDTOBuilder setIdentificador(long identificador);
    ProductoDTOBuilder setTipoDocumento(TipoDocumento tipoDocumento);
    ProductoDTOBuilder setNombre(String nombre);
    ProductoDTOBuilder setApellido(String apellido);
    ProductoDTOBuilder setTelefono(long telefono);
    ProductoDTOBuilder setEmail(String email);
    ProductoDTOBuilder setDireccion(String direccion);
    ProductoDTOBuilder setCiudad(String ciudad);
    ProductoDTOBuilder setAsociacion(Asociacion asociacion);
}
