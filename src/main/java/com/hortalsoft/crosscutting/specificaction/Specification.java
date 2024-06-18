package com.hortalsoft.crosscutting.specificaction;

public interface Specification<T> {
    boolean isSatisfiedBy(T t);
}
