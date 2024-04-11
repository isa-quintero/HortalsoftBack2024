package com.hortalsoft.products.backend.domain.model;

import lombok.*;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
public class Offer {

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
