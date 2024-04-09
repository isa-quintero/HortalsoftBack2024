package com.hortalSoft.products.backend.domain.model;

import com.hortalSoft.users.backend.domain.model.Asociacion;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class PriceRange {

    private long identificador;
    private Product product;
    private Asociacion asociacion;
    @NonNull
    private float rangoInicial;
    @NonNull
    private float rangoFinal;
    @NonNull
    private Date fechaInicial;
    @NonNull
    private Date fechaFinal;
    @NonNull
    private int vigencia;
}
