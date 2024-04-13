package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

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
    @JoinColumn(name="categoryId",nullable = true)
    private CategoryEntity customer;
    @Transient
    private List<ProductEntity> productEntityList;
}
