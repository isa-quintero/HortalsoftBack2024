package com.hortalsoft.products.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private int id;
    @NotNull(message = "El nombre no puede ser nulo")
    private String name;
    private String description;

    public void setDescription(String description) {
        this.description = (description != null) ? description : "";
    }
}
