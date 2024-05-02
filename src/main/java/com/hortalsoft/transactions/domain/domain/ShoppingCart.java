package com.hortalsoft.transactions.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ShoppingCart {
    private int id;
    private String name;
    private String description;
}
