package com.tcs.edu.repository;

public interface Decorator<T> {

    T decorate(T message);
}
