package com.hortalsoft.transactions.domain.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "category",schema = "products")
public class ShppingCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_category")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}
