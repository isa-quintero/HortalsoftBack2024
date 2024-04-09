package com.hortalSoft.products.backend.domain.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class Product {

    private long identificador;
    @NonNull
    private String nombre;
    @NonNull
    private Subcategory subcategory;
    private List<Offer> listaOfferEntities;
    private List<PriceRange> priceRangeList;
}
