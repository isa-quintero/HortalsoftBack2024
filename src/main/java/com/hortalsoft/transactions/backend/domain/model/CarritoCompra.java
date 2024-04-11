package com.hortalsoft.transactions.backend.domain.model;

import com.hortalsoft.products.backend.domain.entity.OfferEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@Getter
@Setter
@Entity
@ToString
@SuperBuilder
@RequiredArgsConstructor
public class CarritoCompra {
    private ArrayList<OfferEntity> listaOfferEntities;
    private int valorTotal;

}
