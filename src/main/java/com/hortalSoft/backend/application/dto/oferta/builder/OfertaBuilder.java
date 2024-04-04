package com.hortalSoft.backend.application.dto.oferta.builder;

import com.hortalSoft.backend.domain.model.Asociacion;
import com.hortalSoft.backend.domain.model.TipoDocumento;

public interface OfertaBuilder {
    OfertaDTOBuilder setIdentificador(long identificador);
    OfertaDTOBuilder setTipoDocumento(TipoDocumento tipoDocumento);
    OfertaDTOBuilder setNombre(String nombre);
    OfertaDTOBuilder setApellido(String apellido);
    OfertaDTOBuilder setTelefono(long telefono);
    OfertaDTOBuilder setEmail(String email);
    OfertaDTOBuilder setDireccion(String direccion);
    OfertaDTOBuilder setCiudad(String ciudad);
    OfertaDTOBuilder setAsociacion(Asociacion asociacion);
}
