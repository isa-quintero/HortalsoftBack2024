package com.hortalsoft.products.domain.specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T t);
}
