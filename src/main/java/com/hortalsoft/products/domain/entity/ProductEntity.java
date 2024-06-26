package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "product", schema = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products.product_seq")
    @SequenceGenerator(name = "products.product_seq", sequenceName = "products.product_seq", allocationSize = 1)
    @Column(name = "id_product")
    private Integer idProduct;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_subcategory")
    private SubcategoryEntity subcategory;
}
