package com.hortalsoft.products.application.dto;

import com.hortalsoft.crosscutting.helper.ObjectHelper;
import com.hortalsoft.crosscutting.helper.TextHelper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;

    @Size(min = 1, max = 100)
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotNull(message = "La subcategoria no puede ser nula ")
    private Integer subcategoryId;

    public void setName(String name) {
        this.name = TextHelper.getDefault(name);
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = ObjectHelper.getDefaultInteger(subcategoryId);
    }

    public String getName() {
        return TextHelper.getDefault(name);
    }

    public Integer getSubcategoryId() {
        return ObjectHelper.getDefaultInteger(subcategoryId);
    }
}