package com.hortalsoft.products.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceRangeDTO {
    private long id;
    @NotNull(message = "El producto no puede ser nulo")
    //TODO eliminar productID y association y descomentar
    //private Product product;
    private long productId;
    @NotNull(message = "La asociación no puede ser nula")
    private String association;
    //private Association association;
    @NotNull(message = "El rango inicial no puede ser nulo")
    private float initialRange;
    @NotNull(message = "El rango final no puede ser nulo")
    private float finalRange;
    @NotNull(message = "La fecha inicial no puede ser nula")
    private LocalDate initialDate;
    @NotNull(message = "La fecha final no puede ser nula")
    private LocalDate finalDate;
    private int validity;
}
