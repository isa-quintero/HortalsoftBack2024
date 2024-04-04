package com.hortalSoft.backend.application.dto;

import com.hortalSoft.backend.domain.model.Oferta;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarritoCompraDTO {
    private ArrayList<Oferta> listaOfertas;
    private int valorTotal;

}
