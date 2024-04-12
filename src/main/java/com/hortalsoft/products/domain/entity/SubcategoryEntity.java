package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "Subcategory")
public class SubcategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = CategoryEntity.class)
    private CategoryEntity categoryEntity;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<ProductEntity> productEntityList;
}
