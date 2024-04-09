package com.hortalSoft.products.backend.domain.model;


import lombok.*;

import java.util.List;

@Data

@Builder
@RequiredArgsConstructor
public class Subcategory {

    private long identificador;
    @NonNull
    private String nombre;
    @NonNull
    private String descripcion;
    @NonNull
    private Category category;
    private List<Product> productEntities;
}
