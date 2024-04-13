package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    private String description;
    @Transient
    private List<SubcategoryEntity> subcategoryEntity;
}
