package ies.castillodeluna.psp.ejercicio_exceptions.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }

}
