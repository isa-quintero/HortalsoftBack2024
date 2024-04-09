package com.hortalSoft.products.backend.domain.model;

import lombok.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Category implements Serializable {

    private long identificador;
    @NonNull
    private String nombre;
    @NonNull
    private String descripcion;
    @NonNull
    private List<Subcategory> subcategory;
}
