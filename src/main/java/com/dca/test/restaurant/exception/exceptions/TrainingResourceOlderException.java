package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceOlderException extends Exception {

    public static final String DESCRIPCION = "Persona menor de edad";

    public TrainingResourceOlderException() {
        super(DESCRIPCION);
    }

    public TrainingResourceOlderException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
