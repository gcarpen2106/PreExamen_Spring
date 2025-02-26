package ies.castillodeluna.pokedex_innovadora.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ies.castillodeluna.pokedex_innovadora.exceptions.InvalidPokemonIdException;
import ies.castillodeluna.pokedex_innovadora.exceptions.PokemonNotFoundException;
import ies.castillodeluna.pokedex_innovadora.exceptions.PokemonValidationException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PokemonErrorHandler {
    
    @ExceptionHandler(PokemonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePokemonNotFound(PokemonNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("timestamp", new Date().toString());
        error.put("error", "Pokémon no encontrado");
        error.put("message", ex.getMessage());
        return error;
    }

    @ExceptionHandler(InvalidPokemonIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleInvalidPokemonId(InvalidPokemonIdException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("timestamp", new Date().toString());
        error.put("error", "ID de Pokémon no válido");
        error.put("message", ex.getMessage());
        return error;
    }

    @ExceptionHandler(PokemonValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handlePokemonValidation(PokemonValidationException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("timestamp", new Date().toString());
        error.put("error", "Error de validación de Pokémon");
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