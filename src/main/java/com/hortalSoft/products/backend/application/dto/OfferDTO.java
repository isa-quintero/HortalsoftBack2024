package com.hortalsoft.products.backend.application.dto;

import lombok.*;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDTO {

    private String id;
    private ProductDTO productDTO;
    private String description;
    private int amount;
    private int price;
    private Date initialDate;
    private Date finalDate;
    private int validity;
}
