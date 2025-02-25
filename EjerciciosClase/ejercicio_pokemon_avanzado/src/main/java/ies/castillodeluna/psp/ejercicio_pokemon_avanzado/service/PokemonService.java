package ies.castillodeluna.psp.ejercicio_pokemon_avanzado.service;

import java.util.List;
import java.util.Optional;

import ies.castillodeluna.psp.ejercicio_pokemon_avanzado.models.Pokemons;

public interface PokemonService {
    
    List<Pokemons> findAll();
    Optional<Pokemons> findById(Long id);
    
    void createPokemon(Pokemons pokemon);
    void deletePokemon(Long id);
    void updatePokemon(Long id , Integer newLevel);
    List<Pokemons> findByType(String type);

    List<Pokemons> findByHit(Long min , Long max);
    List<Object[]> showPokedex();

}
