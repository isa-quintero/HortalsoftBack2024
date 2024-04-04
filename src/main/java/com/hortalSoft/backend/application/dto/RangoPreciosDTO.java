package com.hortalSoft.backend.application.dto;

import com.hortalSoft.backend.domain.model.Asociacion;
import com.hortalSoft.backend.domain.model.Producto;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
