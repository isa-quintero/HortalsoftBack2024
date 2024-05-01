package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "product",schema = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne//(fetch = FetchType.LAZY,targetEntity = SubcategoryEntity.class)
    @JoinColumn(name="subcategoryId",nullable = true,insertable = false, updatable = false)
    private SubcategoryEntity subcategory;


}
