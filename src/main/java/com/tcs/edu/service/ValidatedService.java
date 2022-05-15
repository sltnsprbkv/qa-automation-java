package com.tcs.edu.service;

public abstract class ValidatedService {

    public boolean isArgsValid(String message) {
        return message != null;
    }
}
