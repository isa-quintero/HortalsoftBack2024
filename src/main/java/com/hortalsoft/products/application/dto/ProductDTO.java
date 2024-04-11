package com.hortalsoft.products.application.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private long id;
    private String name;
    private SubcategoryDTO subcategoryDTO;
    private List<OfferDTO> offerDTOList;
    private List<PriceRangeDTO> priceRangeDTOList;
}
