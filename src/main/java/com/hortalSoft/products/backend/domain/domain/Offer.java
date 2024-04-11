package com.hortalsoft.products.backend.domain.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
public class Offer implements Serializable {

    private long id;
    private Product product;
    @NonNull
    private String description;
    private int amount;
    @NonNull
    private int price;
    @NonNull
    private Date initialDate;
    @NonNull
    private Date finalDate;
    @NonNull
    private int validity;
}
