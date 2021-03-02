package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceRequiredException extends Exception {

    public static final String DESCRIPCION = "El campo es requerido";

    public TrainingResourceRequiredException() {
        super(DESCRIPCION);
    }

    public TrainingResourceRequiredException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
