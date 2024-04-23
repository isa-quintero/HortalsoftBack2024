package com.hortalsoft.products.domain.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@ToString
@RequiredArgsConstructor
//@Table(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    //@ManyToOne(fetch = FetchType.LAZY,targetEntity = SubcategoryEntity.class)
    //@JoinColumn(name="subcategoryId",nullable = true)
    //private SubcategoryEntity subcategoryEntity;
    private long codeSubcategory;


}
