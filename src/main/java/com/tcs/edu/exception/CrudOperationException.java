package com.tcs.edu.exception;

public class CrudOperationException extends RuntimeException{

    public CrudOperationException() {
        super();
    }

    public CrudOperationException(String message) {
        super(message);
    }

    public CrudOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
