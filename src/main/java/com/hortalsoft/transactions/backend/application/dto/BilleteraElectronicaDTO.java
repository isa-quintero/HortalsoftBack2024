package com.hortalsoft.transactions.backend.application.dto;

import lombok.*;

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
