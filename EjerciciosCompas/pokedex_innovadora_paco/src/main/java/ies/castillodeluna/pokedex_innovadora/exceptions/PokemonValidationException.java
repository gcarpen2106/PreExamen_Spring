package ies.castillodeluna.pokedex_innovadora.exceptions;

public class PokemonValidationException extends RuntimeException {
    public PokemonValidationException(String message) {
        super(message);
    }
}