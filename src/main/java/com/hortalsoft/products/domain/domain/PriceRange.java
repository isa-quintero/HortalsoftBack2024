package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class PriceRange implements Serializable {
    private long id;
    //TODO eliminar productID y descomentar
    //private Product product;
    private long productId;
    @NonNull
    private String association;
    private float initialRange;
    private float finalRange;
    private Date initialDate;
    private Date finalDate;
    private int validity;
}
