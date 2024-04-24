package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@ToString
@RequiredArgsConstructor
//@Table(name = "Offer")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //TODO se debe descomentar este código y borrar linea codeproduct
    //@ManyToOne(fetch = FetchType.LAZY,targetEntity = ProductEntity.class)
    //@JoinColumn(name="productId",nullable = true)
    //private ProductEntity product;
    private long codeProduct;
    private String description;
    private int amount;
    private int price;
    private Date initialDate;
    private Date finalDate;
    private int validity;
}
