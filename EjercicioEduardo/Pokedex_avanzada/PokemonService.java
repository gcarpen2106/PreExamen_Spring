package ies.castillodeluna.pokedex.services;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import ies.castillodeluna.pokedex.models.Pokemon;

public interface PokemonService {
    List<Pokemon> getAllPokemons();
    Optional<Pokemon> getPokemonById(Long id);
    Pokemon createPokemon(Pokemon pokemon);
    void deletePokemon(Long id);
    Pokemon updatePokemonLevel(Long id, int level);
    List<Pokemon> getPokemonsByType(String type);
    List<Pokemon> getPokemonsByHitPointsRange(Long min, Long max);
    Map<String, Object> getPokemonStats();
}

