package org.certification.funcionalinterfaces.domain;

@FunctionalInterface
public interface Functionable<T,R> {
    R applyThis(T t);
}
