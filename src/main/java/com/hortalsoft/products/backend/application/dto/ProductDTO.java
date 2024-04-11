package com.hortalsoft.products.backend.application.dto;

import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private long id;
    private String name;
    private SubcategoryDTO subcategoryDTO;
    private ArrayList<OfferDTO> offerDTOList;
}
