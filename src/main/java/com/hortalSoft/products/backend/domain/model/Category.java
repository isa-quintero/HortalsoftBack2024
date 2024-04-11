package com.hortalsoft.products.backend.domain.model;

import lombok.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Category implements Serializable {

    private long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private List<Subcategory> subcategory;
}
