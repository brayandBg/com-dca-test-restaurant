package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceTipoContratoException extends Exception {
    public static final String DESCRIPCION = "Error en el campo TipoContrato";

    public TrainingResourceTipoContratoException() {
        super(DESCRIPCION);
    }

    public TrainingResourceTipoContratoException(String message) {
        super(DESCRIPCION + " " + message);
    }
}
