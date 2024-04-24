package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@Entity
@ToString
@RequiredArgsConstructor
//@Table(name = "PriceRange")
public class PriceRangeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //@ManyToOne(fetch = FetchType.LAZY,targetEntity = ProductEntity.class)
    //@JoinColumn(name="productId",nullable = true)
    //private ProductEntity productEntity;
    //@ManyToOne(fetch = FetchType.LAZY,targetEntity = AssociationEntity.class)
    //private AssociationEntity association;

    //TODO Se debe eliminar el string associationy productID y descomentar codigo de arriba
    private long productId;
    private String association;
    private float initialRange;
    private float finalRange;
    private Date initialDate;
    private Date finalDate;
    private int validity;
}
