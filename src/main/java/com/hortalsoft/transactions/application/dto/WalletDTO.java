package com.hortalsoft.transactions.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {
    private int id;
    @NotNull(message = "El producto no puede ser nulo")
    private int productId;
    //private ProductDTO product;
    @NotNull(message = "La asociación no puede ser nula")
    private int associationID;
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
