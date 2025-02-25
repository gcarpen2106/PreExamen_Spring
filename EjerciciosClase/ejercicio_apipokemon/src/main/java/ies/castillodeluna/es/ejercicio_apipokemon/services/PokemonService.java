package ies.castillodeluna.es.ejercicio_apipokemon.services;

import java.util.List;

import ies.castillodeluna.es.ejercicio_apipokemon.models.Pokemon;

public interface PokemonService {
    
    List<Pokemon> findAll();
    List<Pokemon> findByPrefix(String prefix);
    List<Pokemon> findByBuff(String prefix);

}
