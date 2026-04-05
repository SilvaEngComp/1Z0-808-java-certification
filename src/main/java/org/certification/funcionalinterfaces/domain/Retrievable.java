package org.certification.funcionalinterfaces.domain;

@FunctionalInterface
public interface Retrievable<T> {
    T retrieve();
}
