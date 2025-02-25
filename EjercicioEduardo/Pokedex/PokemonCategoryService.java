package ies.castillodeluna.mvc_completo.services;


import java.util.List;
import java.util.Map;

import ies.castillodeluna.mvc_completo.models.Pokemon;

public interface PokemonCategoryService {
    // Devuelve un Map con dos claves: "debil" (hitPoints < 100) y "fuerte" (hitPoints >= 100)
    Map<String, List<Pokemon>> categorizePokemons();
}
