package com.hortalSoft.products.backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@Entity
@ToString
@Builder
@RequiredArgsConstructor
@Table(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long identificador;
    private String nombre;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = SubcategoryEntity.class)
    private SubcategoryEntity subcategoryEntity;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<OfferEntity> listaOfferEntities;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<PriceRangeEntity> priceRangeEntityList;
}
