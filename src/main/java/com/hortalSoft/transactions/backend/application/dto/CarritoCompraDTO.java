package com.hortalSoft.transactions.backend.application.dto;

import com.hortalSoft.products.backend.domain.model.Oferta;
import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarritoCompraDTO {
    private ArrayList<Oferta> listaOfertas;
    private int valorTotal;

}
