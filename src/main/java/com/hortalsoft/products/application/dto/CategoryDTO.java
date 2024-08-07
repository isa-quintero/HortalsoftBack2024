package com.hortalsoft.products.application.dto;

import com.hortalsoft.crosscutting.helper.TextHelper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    @NotNull
    private Integer id;

    @Size(min = 1, max = 100)
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;

    @Size(max = 500)
    @Builder.Default
    private String description = "";


    public void setName(String name) {
        this.name = TextHelper.getDefault(name);
    }

    public void setDescription(String description) {
        this.description = TextHelper.getDefault(description);
    }

    public String getName() {
        return TextHelper.getDefault(name);
    }

    public String getDescription() {
        return TextHelper.getDefault(description);
    }
}
