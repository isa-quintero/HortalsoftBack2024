package com.hortalSoft.backend.domain.model;

import jakarta.persistence.*;
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
public class OrdenEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String identificador;
    private MetodoEntrega metodoEntrega;
    private Date fecha;
    private int costo;
    private String direccionOrigen;
    private String direccionDestino;
    private EstadoOrdeEntrega estadoOrdeEntrega;
    private int tiempoEntrega;
}
