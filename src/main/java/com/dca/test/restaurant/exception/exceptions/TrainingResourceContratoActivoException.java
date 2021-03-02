package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceContratoActivoException extends Exception {


    public static final String DESCRIPCION = "El empleado posee un contrato activo.";

    public TrainingResourceContratoActivoException() {
        super(DESCRIPCION);
    }

    public TrainingResourceContratoActivoException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
