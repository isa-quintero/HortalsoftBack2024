package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "offer", schema = "products")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products.offer_seq")
    @SequenceGenerator(name = "products.offer_seq", sequenceName = "products.offer_seq", allocationSize = 1)
    @Column(name = "id_offer")
    private Integer offerId;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity product;
    @Column(name = "id_farmer")
    private Integer farmer;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "price")
    private Integer price;
    @Column(name = "initial_date")
    private LocalDateTime initialDateOffer;
    @Column(name = "final_date")
    private LocalDateTime finalDateOffer;
    @Column(name = "validity")
    private boolean validity;
    @Column(name = "id_blockchain")
    private String blockchain;

}
