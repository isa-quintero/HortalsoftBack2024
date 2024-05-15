package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "price_range",schema = "products")
public class PriceRangeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products.price_range_seq")
    @SequenceGenerator(name = "products.price_range_seq", sequenceName = "products.price_range_seq", allocationSize = 1)
    @Column(name = "id_price_range")
    private Integer idPriceRange;
    @ManyToOne
    @JoinColumn(name="id_product")
    private ProductEntity product;
    @Column(name = "id_association")
    private Integer associationId;
    @Column(name = "initial_range")
    private BigDecimal initialRange;
    @Column(name = "final_range")
    private BigDecimal finalRange;
    @Column(name = "initial_date")
    private LocalDate initialDatePriceRange;
    @Column(name = "final_date")
    private LocalDate finalDatePriceRange;
    @Column(name = "validity")
    private Integer validity;
}
