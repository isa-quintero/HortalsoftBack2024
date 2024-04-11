package com.hortalsoft.transactions.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceRangeDTO {
    private long id;
    private String name;
    private String description;
    private CategoryDTO categoryDTO;
    private List<ProductDTO> productDTO;
}
