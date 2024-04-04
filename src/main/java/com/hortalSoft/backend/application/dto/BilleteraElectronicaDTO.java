package com.hortalSoft.backend.application.dto;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BilleteraElectronicaDTO {

    private String identificador;
    private String direccionBilletera;
    private String nombre;
    private String email;
    private long fondosDisponibles;
}
