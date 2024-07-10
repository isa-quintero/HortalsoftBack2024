package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public class PriceRange implements Serializable {
    private Integer idPriceRange;
    private Integer productId;
    private Integer associationId;
    private Integer initialRange;
    private Integer finalRange;
    private LocalDateTime initialDate;
    private LocalDateTime finalDate;
    private boolean validity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceRange that = (PriceRange) o;
        return Objects.equals(idPriceRange, that.idPriceRange) && Objects.equals(productId, that.productId) && Objects.equals(associationId, that.associationId) && Objects.equals(initialRange, that.initialRange) && Objects.equals(finalRange, that.finalRange) && Objects.equals(initialDate, that.initialDate) && Objects.equals(finalDate, that.finalDate) && Objects.equals(validity, that.validity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPriceRange, productId, associationId, initialRange, finalRange, initialDate, finalDate, validity);
    }
}
