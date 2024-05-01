package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Product implements Serializable {
    private int id;
    private String name;
    private Subcategory subcategory;
}
