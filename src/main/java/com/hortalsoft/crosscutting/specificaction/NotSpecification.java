package com.hortalsoft.crosscutting.specificaction;

import java.util.Optional;

public final class NotSpecification<T> extends AbstractSpecification<T> {

    private final Specification<T> specification;

    public NotSpecification(final Specification<T> rule) {
        this.specification = Optional.ofNullable(rule).orElseThrow();
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return !specification.isSatisfiedBy(t);
    }

}