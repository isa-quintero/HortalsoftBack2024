package com.hortalsoft.products.backend.domain.model;


import lombok.*;

import java.util.List;

@Data

//@Builder
@RequiredArgsConstructor
public class Subcategory {

    private long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Category category;
    private List<Product> product;
}
