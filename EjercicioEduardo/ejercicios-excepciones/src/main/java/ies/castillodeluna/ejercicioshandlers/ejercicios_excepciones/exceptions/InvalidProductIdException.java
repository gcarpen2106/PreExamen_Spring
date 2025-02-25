package ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.exceptions;

public class InvalidProductIdException extends RuntimeException {
    public InvalidProductIdException(String message) {
        super(message);
    }
}