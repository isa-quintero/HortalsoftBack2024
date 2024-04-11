package com.hortalsoft.transactions.backend.domain.model;

import com.hortalsoft.users.backend.domain.model.Agricultor;
import com.hortalsoft.users.backend.domain.model.Consumidor;
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
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String identificador;
    private Date fecha;
    private Consumidor comprador;
    private Agricultor vendedor;
    private String descripcion;
    private int total;

}
