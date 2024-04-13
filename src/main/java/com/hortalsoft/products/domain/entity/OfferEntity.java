package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "Offer")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ProductEntity.class)
    @JoinColumn(name="productId",nullable = true)
    private ProductEntity customer;
    private String description;
    private int amount;
    private int price;
    private Date initialDate;
    private Date finalDate;
    private int validity;
}
