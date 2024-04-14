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
    private long codeSubcategory;
    private List<PriceRangeDTO> priceRangeDTOList;
}
