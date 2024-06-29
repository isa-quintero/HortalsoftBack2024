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

    public void setName(String name) {
        this.name = TextHelper.getDefault(name);
    }

    public void setDescription(String description) {
        this.description = TextHelper.getDefault(description);
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = ObjectHelper.getDefaultInteger(categoryId);
    }

    public String getName() {
        return TextHelper.getDefault(name);
    }

    public String getDescription() {
        return TextHelper.getDefault(description);
    }

    public Integer getCategoryId() {
        return ObjectHelper.getDefaultInteger(categoryId);
    }

}
