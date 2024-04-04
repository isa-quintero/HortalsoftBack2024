package com.hortalSoft.backend.application.dto.oferta;

import com.hortalSoft.backend.domain.model.Producto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
