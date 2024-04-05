package com.hortalSoft.products.backend.application.dto;

import com.hortalSoft.products.backend.domain.model.Producto;
import com.hortalSoft.users.backend.domain.model.Asociacion;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RangoPreciosDTO {
    private String identificador;
    private Producto producto;
    private Asociacion asociacion;
    private float rangoInicial;
    private float rangoFinal;
    private Date fechaInicial;
    private Date fechaFinal;
    private int vigencia;
}
