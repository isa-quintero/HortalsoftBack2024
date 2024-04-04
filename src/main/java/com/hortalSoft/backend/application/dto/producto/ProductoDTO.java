package com.hortalSoft.backend.application.dto.producto;

import com.hortalSoft.backend.domain.model.Oferta;
import com.hortalSoft.backend.domain.model.Subcategoria;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
