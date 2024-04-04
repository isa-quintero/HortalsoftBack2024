package com.hortalSoft.backend.domain.model;

import com.hortalSoft.backend.application.dto.AsociacionDTO;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@SuperBuilder
@RequiredArgsConstructor
public class RangoPrecios {
    private String identificador;
    private Producto producto;
    private Asociacion asociacion;
    private float rangoInicial;
    private float rangoFinal;
    private Date fechaInicial;
    private Date fechaFinal;
    private int vigencia;
}
