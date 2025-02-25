package ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.controllers;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.exceptions.InvalidProductIdException;
import ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.exceptions.ProductNotFoundException;


@RestControllerAdvice
public class ProductErrorHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleProductNotFound(ProductNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("timestamp", new Date().toString());
        error.put("error", "Producto no encontrado");
        error.put("message", ex.getMessage());
        return error;
    }

    @ExceptionHandler(InvalidProductIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleInvalidProductId(InvalidProductIdException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("timestamp", new Date().toString());
        error.put("error", "ID de producto no válido");
        error.put("message", ex.getMessage());
        return error;
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleNumberFormat(NumberFormatException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("timestamp", new Date().toString());
        error.put("error", "Formato de número incorrecto");
        error.put("message", ex.getMessage());
        return error;
    }
}
