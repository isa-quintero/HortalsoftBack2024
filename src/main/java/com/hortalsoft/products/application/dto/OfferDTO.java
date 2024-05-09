package com.hortalsoft.products.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {
    private int id;
    @NotNull(message = "El producto no puede ser nulo")
    private int productId;
    @NotNull(message = "El producto no puede ser nulo")
    private int farmerId;
    private String description;
    @NotNull(message = "La cantidad no puede ser nula")
    private int amount;
    @NotNull(message = "El precio no puede ser nulo")
    private int price;
    @NotNull(message = "La fecha inicial no puede ser nula")
    private LocalDate initialDate;
    @NotNull(message = "La fecha final no puede ser nula")
    private LocalDate finalDate;
    private int validity;
    private String idBlockchain;

    public void setDescription(String description) {
        this.description = (description != null) ? description : "";
    }
}
