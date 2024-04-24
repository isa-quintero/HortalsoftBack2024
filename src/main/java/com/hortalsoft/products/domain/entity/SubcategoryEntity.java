package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@Entity
@ToString
@RequiredArgsConstructor
//@Table(name = "Subcategory")
public class SubcategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    //TODO se debe descomentar el codigo a continación y borrar codeCategory
    //@ManyToOne(fetch = FetchType.LAZY,targetEntity = CategoryEntity.class)
    //@JoinColumn(name="categoryId",nullable = true)
    //private CategoryEntity category;
    private long codeCategory;
}
