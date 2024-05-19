package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public class PriceRange implements Serializable {
    private Integer id;
    private Integer productId;
    private Integer associationId;
    private BigDecimal initialRange;
    private BigDecimal finalRange;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private Integer validity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceRange that = (PriceRange) o;
        return Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(associationId, that.associationId) && Objects.equals(initialRange, that.initialRange) && Objects.equals(finalRange, that.finalRange) && Objects.equals(initialDate, that.initialDate) && Objects.equals(finalDate, that.finalDate) && Objects.equals(validity, that.validity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, associationId, initialRange, finalRange, initialDate, finalDate, validity);
    }
}
