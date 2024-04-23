package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
//@Builder
@RequiredArgsConstructor
public class Product implements Serializable {
    private long id;
    private String name;
    private long codeSubcategory;


    public Product( String name, long codeSubcategory) {
        this.name = name;
        this.codeSubcategory = codeSubcategory;
    }
}
