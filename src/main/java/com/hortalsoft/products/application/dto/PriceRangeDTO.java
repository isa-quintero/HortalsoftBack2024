package com.hortalsoft.products.application.dto;

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
    private Integer id;
    @NotNull(message = "El producto no puede ser nulo")
    private Integer productId;
    @NotNull(message = "La asociación no puede ser nula")
    private Integer associationId;
    @NotNull(message = "El rango inicial no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false)
    private Double initialRange;
    @NotNull(message = "El rango final no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false)
    private Double finalRange;
    @NotNull(message = "La fecha inicial no puede ser nula")
    @FutureOrPresent
    private LocalDateTime initialDate;
    @NotNull(message = "La fecha final no puede ser nula")
    @FutureOrPresent
    private LocalDateTime finalDate;
    private boolean validity;
}
