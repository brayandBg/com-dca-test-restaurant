package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceDateException extends Exception {


    public static final String DESCRIPCION = "Violación de asignación en la fecha";

    public TrainingResourceDateException() {
        super(DESCRIPCION);
    }

    public TrainingResourceDateException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
