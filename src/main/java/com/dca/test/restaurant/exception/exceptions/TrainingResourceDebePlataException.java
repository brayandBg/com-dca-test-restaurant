package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceDebePlataException extends Exception {


    public static final String DESCRIPCION = "El cliente aun debe valor de la factura";

    public TrainingResourceDebePlataException() {
        super(DESCRIPCION);
    }

    public TrainingResourceDebePlataException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
