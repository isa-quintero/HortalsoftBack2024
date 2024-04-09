package com.hortalSoft.products.backend.application.dto;

import com.hortalSoft.products.backend.domain.entity.SubcategoryEntity;
import com.hortalSoft.products.backend.domain.entity.OfferEntity;
import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private long identificador;
    private String nombre;
    private SubcategoryEntity subcategoryEntity;
    private ArrayList<OfferEntity> listaOfferEntities;
}
