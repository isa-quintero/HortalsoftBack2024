package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class Offer implements Serializable {
    private int id;
    private Product product;
    private int FarmerId;
    private String description;
    private int amount;
    private int price;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private int validity;
}
