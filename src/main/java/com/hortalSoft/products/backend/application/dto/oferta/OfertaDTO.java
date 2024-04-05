package com.hortalSoft.products.backend.application.dto.oferta;

import com.hortalSoft.products.backend.domain.model.Producto;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfertaDTO {

    private String identificador;
    private Producto producto;
    private String descripcion;
    private int cantidad;
    private int precio;
    private Date fechaInicial;
    private Date fechaFinal;
    private int vigencia;
}
