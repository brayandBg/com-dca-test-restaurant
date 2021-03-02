package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceInvalidSalarioException extends Exception {

    public static final String DESCRIPCION = "El salario que trata de registrar está por debajo del mínimo legal vigente";

    public TrainingResourceInvalidSalarioException() {
        super(DESCRIPCION);
    }

    public TrainingResourceInvalidSalarioException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
