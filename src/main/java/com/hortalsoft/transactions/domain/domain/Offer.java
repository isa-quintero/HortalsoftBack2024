package com.hortalsoft.transactions.domain.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class Offer implements Serializable {
    private long id;
    private Product product;
    @NonNull
    private String description;
    private int amount;
    private int price;
    @NonNull
    private Date initialDate;
    @NonNull
    private Date finalDate;
    private int validity;
}
