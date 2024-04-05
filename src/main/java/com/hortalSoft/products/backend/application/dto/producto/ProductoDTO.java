package com.hortalSoft.products.backend.application.dto.producto;

import com.hortalSoft.products.backend.domain.model.Subcategoria;
import com.hortalSoft.products.backend.domain.model.Oferta;
import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private long identificador;
    private String nombre;
    private Subcategoria subcategoria;
    private ArrayList<Oferta> listaOfertas;
}
