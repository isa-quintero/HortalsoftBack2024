package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Subcategory implements Serializable {
    private int id;
    private String name;
    private String description;
    private int categoryId;
    //private Category category;
}
