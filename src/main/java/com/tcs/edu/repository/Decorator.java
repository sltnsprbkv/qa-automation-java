package com.tcs.edu.repository;

public interface Decorator<T> {

    String decorate(T message);
}
