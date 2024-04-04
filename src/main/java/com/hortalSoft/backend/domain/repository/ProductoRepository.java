package com.hortalSoft.backend.domain.repository;

import com.hortalSoft.backend.domain.model.Producto;
import com.hortalSoft.backend.infraestructure.adapter.repository.jpa.ProductoRepositorioJpa;

import java.util.List;

public interface ProductoRepository extends ProductoRepositorioJpa {
    Producto getById();
    Producto findByName(String name);
    List<Producto> getAll();
    Producto save(Producto producto);

    boolean exist(Producto producto);

    Long delete(Producto producto);
}
