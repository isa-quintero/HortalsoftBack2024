package com.hortalsoft.products.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryDTO {
    private int id;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    private String description;
    @NotNull(message = "La categoría no puede ser nula")
    private CategoryDTO categoryDTO;

    public void setDescription(String description) {
        this.description = (description != null) ? description : "";
    }
}
