package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceFieldInvalidException extends Exception {


    public static final String DESCRIPCION = "Campo o tipo de dato inválido";

    public TrainingResourceFieldInvalidException() {
        super(DESCRIPCION);
    }

    public TrainingResourceFieldInvalidException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
