package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceNotAssociateException extends Exception {

    public static final String DESCRIPCION = "No hay recursos disponibles";

    public TrainingResourceNotAssociateException() {
        super(DESCRIPCION);
    }

    public TrainingResourceNotAssociateException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
