package com.hortalsoft.products.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "offer",schema = "products")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products.offer_seq")
    @SequenceGenerator(name = "products.offer_seq", sequenceName = "products.offer_seq", allocationSize = 1)
    @Column(name = "id_offer")
    private Integer idOffer;
    @ManyToOne
    @JoinColumn(name="id_product")
    private ProductEntity product;
    @Column(name = "id_farmer")
    private Integer idFarmer;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "price")
    private Integer price;
    @Column(name = "initial_date")
    private LocalDate initialDateOffer;
    @Column(name = "final_date")
    private LocalDate finalDateOffer;
    @Column(name = "validity")
    private Integer validity;
    @Column(name = "id_blockchain")
    private String idBlockchain;

}
