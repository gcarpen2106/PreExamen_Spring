package ies.castillodeluna.pokedex_innovadora.exceptions;

public class InvalidPokemonIdException extends RuntimeException {
    public InvalidPokemonIdException(String message) {
        super(message);
    }
}