package com.tcs.edu.service;

public abstract class ValidatedService {

    public void isArgsValid(String message) {
        if (message == null || message.equals("null")) throw new IllegalArgumentException("message is null");
        if (message.length() == 0) throw new IllegalArgumentException("message is empty");
    }
}
