package com.hortalsoft.products.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    @NotNull(message = "La subcategoria no puede ser nula ")
    private int subcategoryId;
}
