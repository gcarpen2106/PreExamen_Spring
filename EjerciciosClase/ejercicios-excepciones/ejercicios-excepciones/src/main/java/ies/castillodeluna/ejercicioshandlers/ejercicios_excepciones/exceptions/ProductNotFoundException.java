package ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}