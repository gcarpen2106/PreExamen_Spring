package ies.castillodeluna.psp.spring_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import ies.castillodeluna.psp.spring_error.exceptions.UserNotFoundException;
import ies.castillodeluna.psp.spring_error.models.ErrorM;

@RestControllerAdvice
public class ErrorHadlerException {
    
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> divisionByZero (Exception ex){

        // ErrorM errorM = new ErrorM();

        // errorM.setError("Division por cero");
        // errorM.setMessage(ex.getMessage());
        // errorM.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        // errorM.setDate(new Date());

        // return ResponseEntity.internalServerError().body(errorM);

        return ResponseEntity.internalServerError().body("Esto es un error 500");

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorM> notFoundEx(NoHandlerFoundException ex){

        ErrorM errorM = new ErrorM();

        errorM.setError("No encontrado");
        errorM.setDate(new Date());
        errorM.setMessage(ex.getMessage());
        errorM.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorM);

    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> numberFormatException(Exception ex){

        Map<String, String> error = new HashMap<>();

        error.put("error", "Numero incorrecto o formato de numero incorrecto");
        error.put("date", new Date().toString());
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value() + "");

        return error;

    }

    @ExceptionHandler({HttpMessageNotWritableException.class , NullPointerException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String , String> userNotFoundEx(Exception ex){

        Map<String, String> error = new HashMap<>();

        error.put("error", "No se ha encontrado un usuario con ese ID");
        error.put("date", new Date().toString());
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value() + "");

        

        return error;

    }

}
