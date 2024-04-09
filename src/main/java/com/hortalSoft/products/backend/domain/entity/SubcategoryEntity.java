package com.hortalSoft.products.backend.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@ToString
@Builder
@RequiredArgsConstructor
@Table(name = "Subcategory")
public class SubcategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String identificador;
    private String nombre;
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = CategoryEntity.class)
    private CategoryEntity categoryEntity;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<ProductEntity> productEntities;
}
