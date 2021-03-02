package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceConstraintException extends Exception {

    public static final String DESCRIPCION = "Violación de registro de llave unica";

    public TrainingResourceConstraintException() {
        super(DESCRIPCION);
    }

    public TrainingResourceConstraintException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
