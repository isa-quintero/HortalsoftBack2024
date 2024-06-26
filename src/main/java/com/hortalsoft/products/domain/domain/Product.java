package com.hortalsoft.products.domain.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public class Product implements Serializable {
    private Integer id;
    private String name;
    private Integer subCategoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(subCategoryId, product.subCategoryId) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subCategoryId);
    }
}
