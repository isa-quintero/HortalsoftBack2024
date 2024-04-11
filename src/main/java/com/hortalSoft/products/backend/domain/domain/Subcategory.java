package com.hortalsoft.products.backend.domain.domain;


import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data

//@Builder
@RequiredArgsConstructor
public class Subcategory implements Serializable {

    private long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Category category;
    private List<Product> product;
}
