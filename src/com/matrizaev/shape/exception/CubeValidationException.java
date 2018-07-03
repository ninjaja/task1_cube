package com.matrizaev.shape.exception;

public class CubeValidationException extends Exception {

    public CubeValidationException() {
        super();
    }

    public CubeValidationException(String message) {
        super(message);
    }

    public CubeValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CubeValidationException(Throwable cause) {
        super(cause);
    }
}
