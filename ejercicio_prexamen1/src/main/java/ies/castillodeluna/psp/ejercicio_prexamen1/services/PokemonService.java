package ies.castillodeluna.psp.ejercicio_prexamen1.services;

import java.util.List;
import java.util.Optional;

import ies.castillodeluna.psp.ejercicio_prexamen1.models.Pokemon;

public interface PokemonService {
    
    List<Pokemon> findAll();
    Optional<Pokemon> findById(Long id);
    List<Pokemon> findByName(String name);
    void actualizarPokemon(Long id , String type);
    Integer deletePokemon(Integer minLevel, Integer maxLevel);
    void evolucionarPokemons(Long id , Integer levelIncrement , Long hitPoint);
    List<Pokemon> findByMinLevel(Integer minLevel);

}
