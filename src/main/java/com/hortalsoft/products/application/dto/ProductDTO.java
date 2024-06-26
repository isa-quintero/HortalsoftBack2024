package com.hortalsoft.products.application.dto;

import com.hortalsoft.crosscutting.helper.ObjectHelper;
import com.hortalsoft.crosscutting.helper.TextHelper;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private Integer subcategoryId;

    //Se modifican los setters para usar getDefault y reemplazar los valores nulos por valores por defecto apropiados
    public void setName(String name) {
        this.name = TextHelper.getDefault(name);
    }

    // Se asume el 0 como valor por defecto para la subcategoria.
    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = ObjectHelper.getDefault(subcategoryId, 0);
    }
}