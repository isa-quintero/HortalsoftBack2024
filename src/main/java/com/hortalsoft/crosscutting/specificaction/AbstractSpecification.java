package com.hortalsoft.crosscutting.specificaction;


public abstract class AbstractSpecification<T> implements Specification<T> {

    public AbstractSpecification<T> or(Specification<T> specification) {
        return new OrSpecification<>(this, specification);
    }

    public AbstractSpecification<T> and(Specification<T> specification) {
        return new AndSpecification<>(this, specification);
    }

    public AbstractSpecification<T> not() {
        return new NotSpecification<>(this);
    }
}