package com.hortalsoft.products.application.dto;

import com.hortalsoft.crosscutting.helper.ObjectHelper;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceRangeDTO {
    private Integer idPriceRange;

    @NotNull(message = "El producto no puede ser nulo")
    private Integer productId;

    @NotNull(message = "La asociación no puede ser nula")
    private Integer associationId;

    @NotNull(message = "El rango inicial no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false)
    private Integer initialRange;

    @NotNull(message = "El rango final no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false)
    private Integer finalRange;

    @NotNull(message = "La fecha inicial no puede ser nula")
    @FutureOrPresent
    private LocalDateTime initialDate;

    @NotNull(message = "La fecha final no puede ser nula")
    @FutureOrPresent
    private LocalDateTime finalDate;

    private boolean validity;

    public void setIdPriceRange(Integer idPriceRange) {
        this.idPriceRange = ObjectHelper.getDefaultInteger(idPriceRange);
    }
    // Setters using helpers
    public void setProductId(Integer productId) {
        this.productId = ObjectHelper.getDefaultInteger(productId);
    }

    public void setAssociationId(Integer associationId) {
        this.associationId = ObjectHelper.getDefaultInteger(associationId);
    }

    public void setInitialRange(Integer initialRange) {
        this.initialRange = ObjectHelper.isNull(initialRange) ? 0 : initialRange;
    }

    public void setFinalRange(Integer finalRange) {
        this.finalRange = ObjectHelper.isNull(finalRange) ? 0: finalRange;
    }

    public void setInitialDate(LocalDateTime initialDate) {
        this.initialDate = ObjectHelper.isNull(initialDate) ? LocalDateTime.now() : initialDate;
    }

    public void setFinalDate(LocalDateTime finalDate) {
        this.finalDate = ObjectHelper.isNull(finalDate) ? LocalDateTime.now() : finalDate;
    }

    // Getters using helpers
    public Integer getIdPriceRange() {
        return ObjectHelper.getDefaultInteger(idPriceRange);
    }
    public Integer getProductId() {
        return ObjectHelper.getDefaultInteger(productId);
    }

    public Integer getAssociationId() {
        return ObjectHelper.getDefaultInteger(associationId);
    }

    public Double getInitialRange() {
        return ObjectHelper.isNull(initialRange) ? 0.0 : initialRange;
    }

    public Double getFinalRange() {
        return ObjectHelper.isNull(finalRange) ? 0.0 : finalRange;
    }

    public LocalDateTime getInitialDate() {
        return ObjectHelper.isNull(initialDate) ? LocalDateTime.now() : initialDate;
    }

    public LocalDateTime getFinalDate() {
        return ObjectHelper.isNull(finalDate) ? LocalDateTime.now() : finalDate;
    }
}

