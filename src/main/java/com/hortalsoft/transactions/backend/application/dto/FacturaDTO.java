package com.hortalsoft.transactions.backend.application.dto;

import com.hortalsoft.users.backend.domain.model.Agricultor;
import com.hortalsoft.users.backend.domain.model.Consumidor;
import lombok.*;

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