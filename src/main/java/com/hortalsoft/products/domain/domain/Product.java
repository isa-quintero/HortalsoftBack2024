package com.hortalsoft.products.domain.domain;

import jakarta.persistence.Transient;
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
    private long codeSubcategory;
    @Transient
    private List<Offer> offerList;
    @Transient
    private List<PriceRange> priceRangeList;
}
