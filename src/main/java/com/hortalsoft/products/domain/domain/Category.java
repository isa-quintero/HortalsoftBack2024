package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Category {
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private List<Subcategory> subcategory;
}