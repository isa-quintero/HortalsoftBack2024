package com.hortalsoft.products.backend.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@ToString
//@Builder
@RequiredArgsConstructor
@Table(name = "Subcategory")
public class SubcategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = CategoryEntity.class)
    private CategoryEntity categoryEntity;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<ProductEntity> productEntityList;
}
