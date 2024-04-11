package com.hortalsoft.users.domain.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Subcategory implements Serializable {
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Association association;
    private List<Product> product;
}
