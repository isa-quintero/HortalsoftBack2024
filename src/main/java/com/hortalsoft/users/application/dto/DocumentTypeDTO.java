package com.hortalsoft.users.application.dto;

import com.hortalsoft.crosscutting.helper.TextHelper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentTypeDTO {
    private Integer id;

    private String code;

    @Size(min = 1, max = 100)
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @Size(max = 500)
    @Builder.Default
    private String description = "";

    // Setters using helpers
    public void setName(String name) {
        this.name = TextHelper.getDefault(name);
    }

    public void setCode(String code) {
        this.code = TextHelper.getDefault(code);
    }

    public void setDescription(String description) {
        this.description = TextHelper.getDefault(description);
    }

    // Getters using helpers
    public String getName() {
        return TextHelper.getDefault(name);
    }

    public String getCode() {
        return TextHelper.getDefault(code);
    }

    public String getDescription() {
        return TextHelper.getDefault(description);
    }
}

