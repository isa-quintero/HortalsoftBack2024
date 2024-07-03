package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "category", schema = "products")
public class CategoryEntity {
    @Id
    @Column(name = "id_category")
    private Integer idCategory;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}
