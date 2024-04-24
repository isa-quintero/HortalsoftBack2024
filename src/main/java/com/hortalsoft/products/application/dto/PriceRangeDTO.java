package com.hortalsoft.products.application.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceRangeDTO {
    private long id;
    //TODO eliminar productID y association y descomentar
    //private Product product;
    private long productId;
    private String association;
    //private Association association;
    private float initialRange;
    private float finalRange;
    private Date initialDate;
    private Date finalDate;
    private int validity;
}
