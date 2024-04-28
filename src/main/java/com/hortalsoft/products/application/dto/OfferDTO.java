package com.hortalsoft.products.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {
    private long id;
    @NotNull(message = "El producto no puede ser nulo")
    //TODO eliminar codeProduct y descomentar
    //private ProductDTO productDTO;
    //private FarmerDTO farmerDTO;
    private long codeProduct;
    private long codeFarmer;
    private String description;
    @NotNull(message = "La cantidad no puede ser nula")
    private int amount;
    @NotNull(message = "El precio no puede ser nulo")
    private int price;
    @NotNull(message = "La fecha inicial no puede ser nula")
    private Date initialDate;
    @NotNull(message = "La fecha final no puede ser nula")
    private Date finalDate;
    private int validity;

    public void setDescription(String description) {
        this.description = (description != null) ? description : "";
    }
}
