package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@ToString
@RequiredArgsConstructor
//TODO descomentar
//@Table(name = "Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;
}
