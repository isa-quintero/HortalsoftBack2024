package com.hortalsoft.products.backend.domain.domain;

import lombok.*;

import java.util.List;

@Data
//@Builder
@RequiredArgsConstructor
public class Product {

    private long id;
    @NonNull
    private String name;
    @NonNull
    private Subcategory subcategory;
    private List<Offer> offerList;
    private List<PriceRange> priceRangeList;
}
