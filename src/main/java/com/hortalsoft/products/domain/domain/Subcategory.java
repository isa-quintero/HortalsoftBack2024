package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Subcategory implements Serializable {
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    //TODO eliminar codeCategory y descomentar
    //@NonNull
    //private transient Category category;
    private long codeCategory;
}
