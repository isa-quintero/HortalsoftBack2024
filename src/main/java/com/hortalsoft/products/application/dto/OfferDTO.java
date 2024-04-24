package com.hortalsoft.products.application.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {
    private long id;
    //TODO eliminar codeProduct y descomentar
    //private ProductDTO productDTO;
    private long codeProduct;
    private String description;
    private int amount;
    private int price;
    private Date initialDate;
    private Date finalDate;
    private int validity;
}
