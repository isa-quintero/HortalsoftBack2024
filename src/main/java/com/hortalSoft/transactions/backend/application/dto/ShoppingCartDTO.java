package com.hortalsoft.transactions.backend.application.dto;

import com.hortalsoft.products.backend.domain.entity.OfferEntity;
import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {
    private ArrayList<OfferEntity> offerEntityList;
    private int totalCost;

}
