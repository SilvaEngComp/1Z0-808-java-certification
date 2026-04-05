package org.certification.funcionalinterfaces.domain;

@FunctionalInterface
public interface Evaluate<T> {
    boolean isNegative(T t);
}
