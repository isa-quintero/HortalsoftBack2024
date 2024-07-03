package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "subcategory", schema = "products")
public class SubcategoryEntity {
    @Id
    @Column(name = "id_subcategory")
    private Integer idSubcategory;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;
}
