package com.hortalSoft.backend.application.dto;

import com.hortalSoft.backend.domain.model.Pais;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTO {

    private String identificador;
    private String nombre;
    private Pais pais;
    private boolean estado;
}
