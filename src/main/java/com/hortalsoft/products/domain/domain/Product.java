package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Product implements Serializable {
    private long id;
    private String name;
    //TODO eliminar codeSubcategory y descomentar código
    private long codeSubcategory;
    //private Subcategory subcategory;



}
