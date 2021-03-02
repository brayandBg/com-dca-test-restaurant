package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceNotFoundException extends Exception {

    public static final String DESCRIPCION = "Registro no encontrado";

    public TrainingResourceNotFoundException() {
        super(DESCRIPCION);
    }

    public TrainingResourceNotFoundException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
