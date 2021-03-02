package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceExistsException extends Exception {

    public static final String DESCRIPCION = "Existe";

    public TrainingResourceExistsException() {
        super(DESCRIPCION);
    }

    public TrainingResourceExistsException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
