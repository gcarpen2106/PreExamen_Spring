package ies.castillodeluna.psp.ejercicio_prexamen2.service;

import java.util.List;
import java.util.Optional;

import ies.castillodeluna.psp.ejercicio_prexamen2.models.Pokemons;

public interface PokemonService {
 
    Optional<Pokemons> findById(Long id);
    Optional<Pokemons> getPokemonById(Long id);
    List<Pokemons> findByAdvancedFilter(String type , Integer minLevel , Integer maxLevel);
    List<Pokemons> findByLegendary(Boolean legendary);
    void updateCaptureRate(Long id  , Integer captureRate);
    void registrarEvolucion(Long id , Integer levelIncrement , Long hitPointsIncrement , String newEvolution);
    Optional<Pokemons> deletePokemonById(Long id);

}
