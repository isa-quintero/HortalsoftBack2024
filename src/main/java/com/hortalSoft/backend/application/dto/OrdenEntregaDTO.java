package com.hortalSoft.backend.application.dto;

import com.hortalSoft.backend.domain.model.EstadoOrdeEntrega;
import com.hortalSoft.backend.domain.model.MetodoEntrega;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdenEntregaDTO {

    private String identificador;
    private MetodoEntrega metodoEntrega;
    private Date fecha;
    private int costo;
    private String direccionOrigen;
    private String direccionDestino;
    private EstadoOrdeEntrega estadoOrdeEntrega;
    private int tiempoEntrega;
}
