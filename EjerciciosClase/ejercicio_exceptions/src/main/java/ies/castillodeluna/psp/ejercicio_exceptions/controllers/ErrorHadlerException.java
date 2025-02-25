package ies.castillodeluna.psp.ejercicio_exceptions.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ies.castillodeluna.psp.ejercicio_exceptions.exceptions.InvalidProductIdException;
import ies.castillodeluna.psp.ejercicio_exceptions.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class ErrorHadlerException {
    
    @ExceptionHandler({ProductNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String , String> productNotFound(Exception ex){

        Map<String , String> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("date", new Date().toString());
        error.put("error", "Product not found");
        error.put("status", HttpStatus.NOT_FOUND.value() + "");

        return error;

    }

    @ExceptionHandler({InvalidProductIdException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String , String> invalidProduct(Exception ex){

        Map<String , String> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("date", new Date().toString());
        error.put("error", "Invalid product id");
        error.put("status", HttpStatus.BAD_REQUEST.value() + "");

        return error;

    }

    @ExceptionHandler({NumberFormatException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String , String> numberFormat(Exception ex){

        Map<String , String> error = new HashMap<>();

        error.put("message", ex.getMessage());
        error.put("date", new Date().toString());
        error.put("error", "Internal server error");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value() + "");

        return error;

    }

}
