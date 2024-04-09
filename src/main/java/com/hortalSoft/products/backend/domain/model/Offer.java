package com.hortalSoft.products.backend.domain.model;

import lombok.*;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
public class Offer {

    private long identificador;
    private Product product;
    @NonNull
    private String descripcion;
    private int cantidad;
    @NonNull
    private int precio;
    @NonNull
    private Date fechaInicial;
    @NonNull
    private Date fechaFinal;
    @NonNull
    private int vigencia;
}
