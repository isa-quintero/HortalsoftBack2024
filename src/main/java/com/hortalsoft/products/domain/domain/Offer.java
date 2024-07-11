package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public class Offer implements Serializable {
    private Integer id;
    private Integer productId;
    private Integer farmer;
    private String description;
    private Integer amount;
    private Integer price;
    private LocalDateTime initialDate;
    private LocalDateTime finalDate;
    private boolean validity;
    private String idBlockchain;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(id, offer.id) && Objects.equals(productId, offer.productId) && Objects.equals(farmer, offer.farmer) && Objects.equals(description, offer.description) && Objects.equals(amount, offer.amount) && Objects.equals(price, offer.price) && Objects.equals(initialDate, offer.initialDate) && Objects.equals(finalDate, offer.finalDate) && Objects.equals(validity, offer.validity) && Objects.equals(idBlockchain, offer.idBlockchain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, farmer, description, amount, price, initialDate, finalDate, validity, idBlockchain);
    }
}
