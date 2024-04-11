package com.hortalsoft.products.backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@ToString
//@Builder
@RequiredArgsConstructor
@Table(name = "Offer")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ProductEntity.class)
    private ProductEntity productEntity;
    private String description;
    private int amount;
    private int price;
    private Date initialDate;
    private Date finalDate;
    private int validity;
}
