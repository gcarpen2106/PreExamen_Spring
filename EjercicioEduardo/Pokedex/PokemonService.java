package ies.castillodeluna.mvc_completo.services;


import java.util.List;

import ies.castillodeluna.mvc_completo.models.Pokemon;

public interface PokemonService {
    List<Pokemon> getAllPokemons();
    List<Pokemon> getPokemonsByNamePrefix(String prefix);
    // Método que aplica el buff (10% extra en hitPoints)
    List<Pokemon> getBuffedPokemonsByNamePrefix(String prefix);
}
