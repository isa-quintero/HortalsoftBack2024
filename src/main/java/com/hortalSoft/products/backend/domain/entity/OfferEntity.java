package com.hortalSoft.products.backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Builder
@RequiredArgsConstructor
@Table(name = "Offer")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long identificador;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ProductEntity.class)
    private ProductEntity productEntity;
    private String descripcion;
    private int cantidad;
    private int precio;
    private Date fechaInicial;
    private Date fechaFinal;
    private int vigencia;
}
