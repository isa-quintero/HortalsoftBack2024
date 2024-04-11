package com.hortalsoft.products.backend.domain.domain;

import com.hortalsoft.users.backend.domain.model.Association;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class PriceRange implements Serializable {

    private long id;
    private Product product;
    private Association association;
    @NonNull
    private float initialRange;
    @NonNull
    private float finalRange;
    @NonNull
    private Date initialDate;
    @NonNull
    private Date finalDate;
    @NonNull
    private int validity;
}