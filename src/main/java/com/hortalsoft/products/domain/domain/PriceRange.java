package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class PriceRange implements Serializable {
    private long id;
    //TODO eliminar productID y association y descomentar
    //private Product product;
    private long productId;
    @NonNull
    private String association;
    //private Association association;
    private float initialRange;
    private float finalRange;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private int validity;
}
