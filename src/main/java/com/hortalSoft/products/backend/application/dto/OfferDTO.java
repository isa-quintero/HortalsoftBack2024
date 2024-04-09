package com.hortalSoft.products.backend.application.dto;

import com.hortalSoft.products.backend.domain.entity.ProductEntity;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDTO {

    private String identificador;
    private ProductEntity productEntity;
    private String descripcion;
    private int cantidad;
    private int precio;
    private Date fechaInicial;
    private Date fechaFinal;
    private int vigencia;
}
