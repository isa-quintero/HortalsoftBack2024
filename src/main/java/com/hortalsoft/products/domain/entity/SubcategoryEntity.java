package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "subcategory",schema="products")
public class SubcategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_subcategory")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne//(fetch = FetchType.LAZY,targetEntity = CategoryEntity.class)
    @JoinColumn(name="id_category")
    private CategoryEntity category;
}
