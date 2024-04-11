package com.hortalsoft.products.domain.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = SubcategoryEntity.class)
    private SubcategoryEntity subcategoryEntity;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<OfferEntity> offerEntityList;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<PriceRangeEntity> priceRangeEntityList;
}
