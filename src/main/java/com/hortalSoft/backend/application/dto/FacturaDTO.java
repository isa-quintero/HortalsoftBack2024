package com.hortalSoft.backend.application.dto;

import com.hortalSoft.backend.domain.model.Agricultor;
import com.hortalSoft.backend.domain.model.Consumidor;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {

    private String identificador;
    private Date fecha;
    private Consumidor comprador;
    private Agricultor vendedor;
    private String descripcion;
    private int total;

}
