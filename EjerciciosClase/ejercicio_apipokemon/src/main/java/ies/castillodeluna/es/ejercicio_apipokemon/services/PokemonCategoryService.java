package ies.castillodeluna.es.ejercicio_apipokemon.services;

import java.util.List;

import ies.castillodeluna.es.ejercicio_apipokemon.models.Pokemon;

public interface PokemonCategoryService {
    
    List<Pokemon> findAll();
    List<Pokemon> findByHighHitPoint();
    List<Pokemon> findByLowHitPoint();


}
