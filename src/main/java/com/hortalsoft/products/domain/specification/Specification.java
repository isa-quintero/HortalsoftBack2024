package com.hortalsoft.products.domain.specification;

public interface Specification <T>{
    public boolean isSatisfiedBy(T t);
}
