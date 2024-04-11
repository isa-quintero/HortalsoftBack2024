package com.hortalsoft.users.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
