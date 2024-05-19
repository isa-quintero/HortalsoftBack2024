package com.hortalsoft.products.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryDTO {
    private Integer id;
    @Size(min = 1, max = 100)
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    @Size(max = 500)
    @Builder.Default
    private String description = "";
    @NotNull(message = "La categoría no puede ser nula")
    private Integer categoryId;
}
