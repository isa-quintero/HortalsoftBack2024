package com.hortalsoft.transactions.domain.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
//@Builder
@RequiredArgsConstructor
public class Product implements Serializable {
    private long id;
    @NonNull
    private String name;
    @NonNull
    private Subcategory subcategory;
    private List<Offer> offerList;
    private List<PriceRange> priceRangeList;
}
