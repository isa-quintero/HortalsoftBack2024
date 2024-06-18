package com.hortalsoft.crosscutting.specificaction;

import java.util.Optional;

public final class AndSpecification<T> extends AbstractSpecification<T> {

    private final Specification<T> specificationA;
    private final Specification<T> specificationB;

    public AndSpecification(final Specification<T> ruleA, final Specification<T> ruleB) {
        specificationA = Optional.ofNullable(ruleA).orElseThrow();
        specificationB = Optional.ofNullable(ruleB).orElseThrow();
    }

    public boolean isSatisfiedBy(final T t) {
        return specificationA.isSatisfiedBy(t) && specificationB.isSatisfiedBy(t);
    }
}