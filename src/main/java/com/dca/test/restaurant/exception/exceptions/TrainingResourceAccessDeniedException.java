package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceAccessDeniedException extends Exception {

    public static final String DESCRIPCION = "No tiene acceso al recurso solicitado";

    public TrainingResourceAccessDeniedException() {
        super(DESCRIPCION);
    }

    public TrainingResourceAccessDeniedException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
