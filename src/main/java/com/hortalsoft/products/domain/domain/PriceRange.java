package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class PriceRange implements Serializable {
    private int id;
    private int productId;
    //private Product product;
    private int associationId;
    private float initialRange;
    private float finalRange;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private int validity;
}
