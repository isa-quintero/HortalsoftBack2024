package com.hortalSoft.products.backend.domain.entity;

import com.hortalSoft.users.backend.domain.model.Asociacion;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@ToString
@Builder
@RequiredArgsConstructor
@Table(name = "PriceRange")
public class PriceRangeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long identificador;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ProductEntity.class)
    private ProductEntity productEntity;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Asociacion.class)
    private Asociacion asociacion;
    private float rangoInicial;
    private float rangoFinal;
    private Date fechaInicial;
    private Date fechaFinal;
    private int vigencia;
}
