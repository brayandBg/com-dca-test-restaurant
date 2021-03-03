package com.dca.test.restaurant.exception.exceptions;

public class TrainingResourceNotVentasException extends Exception {

    public static final String DESCRIPCION = "Debe agregar al menos un producto para generar factura";

    public TrainingResourceNotVentasException() {
        super(DESCRIPCION);
    }

    public TrainingResourceNotVentasException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
