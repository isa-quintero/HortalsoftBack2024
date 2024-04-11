package com.hortalsoft.transactions.backend.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@ToString
@SuperBuilder
@RequiredArgsConstructor
public class BilleteraElectronica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String identificador;
    private String direccionBilletera;
    private String nombre;
    private String email;
    private long fondosDisponibles;
}