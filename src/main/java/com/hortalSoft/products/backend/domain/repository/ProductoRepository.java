package com.hortalSoft.products.backend.domain.repository;

import com.hortalSoft.products.backend.domain.model.Producto;
import com.hortalSoft.products.backend.infraestructure.adapter.repository.jpa.ProductoRepositorioJpa;

import java.util.List;

public interface ProductoRepository extends ProductoRepositorioJpa {
    com.hortalSoft.products.backend.domain.model.Producto getById();
    com.hortalSoft.products.backend.domain.model.Producto findByName(String name);
    List<com.hortalSoft.products.backend.domain.model.Producto> getAll();
    com.hortalSoft.products.backend.domain.model.Producto save(com.hortalSoft.products.backend.domain.model.Producto producto);

    boolean exist(com.hortalSoft.products.backend.domain.model.Producto producto);

    Long delete(Producto producto);
}
