package com.hortalsoft.products.application.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {
    @NotNull
    private Integer id;
    @NotNull(message = "El producto no puede ser nulo")
    private Integer productId;
    @NotNull(message = "El agricultor no puede ser nulo")
    private Integer farmerId;
    @Size(max = 500)
    @Builder.Default
    private String description = "";
    @NotNull(message = "La cantidad no puede ser nula")
    @Min(1)
    private Integer amount;
    @NotNull(message = "El precio no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false)
    private Double price;
    @NotNull(message = "La fecha inicial no puede ser nula")
    @FutureOrPresent
    private LocalDateTime initialDate;
    @NotNull(message = "La fecha final no puede ser nula")
    @FutureOrPresent
    private LocalDateTime finalDate;
    private boolean validity;
    private String idBlockchain;
}
