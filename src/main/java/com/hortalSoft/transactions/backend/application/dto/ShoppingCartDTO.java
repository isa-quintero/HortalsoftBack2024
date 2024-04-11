package com.hortalSoft.transactions.backend.application.dto;

import com.hortalSoft.products.backend.domain.entity.OfferEntity;
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
