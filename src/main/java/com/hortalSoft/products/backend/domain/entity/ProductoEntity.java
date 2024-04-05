package com.hortalSoft.products.backend.domain.entity;


import com.hortalSoft.products.backend.domain.model.Oferta;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;



import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Category")
public class ProductoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long identificador;
    @NotNull
    private String nombre;
    @NotNull
    private String subcategoria;
    @NotNull
    private ArrayList<Oferta> listaOfertas;

}
