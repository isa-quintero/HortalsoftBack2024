package com.hortalsoft.transactions.domain.entity;

import com.hortalsoft.products.domain.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "price_range",schema = "products")
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products.price_range_seq")
    @SequenceGenerator(name = "products.price_range_seq", sequenceName = "products.price_range_seq", allocationSize = 1)
    @Column(name = "id_price_range")
    private int id;
    @ManyToOne//(fetch = FetchType.LAZY,targetEntity = ProductEntity.class)
    @JoinColumn(name="id_product")
    private ProductEntity product;
    @Column(name = "id_association")
    private int associationId;
    @Column(name = "initial_range")
    private float initialRange;
    @Column(name = "final_range")
    private float finalRange;
    @Column(name = "initial_date")
    private LocalDate initialDate;
    @Column(name = "final_date")
    private LocalDate finalDate;
    @Column(name = "validity")
    private int validity;
}
