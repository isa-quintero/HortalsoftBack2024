package com.hortalsoft.products.backend.application.dto;

import com.hortalSoft.users.backend.domain.model.Association;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceRangeDTO {
    private String id;
    private ProductDTO productDTO;
    private Association association;
    private float initialRange;
    private float finalRange;
    private Date initialDate;
    private Date fInalDate;
    private int validity;
}
