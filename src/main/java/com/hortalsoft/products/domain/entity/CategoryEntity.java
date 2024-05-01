package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "category",schema = "products")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}
