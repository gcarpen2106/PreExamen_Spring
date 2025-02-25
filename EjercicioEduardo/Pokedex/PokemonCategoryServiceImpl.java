package ies.castillodeluna.mvc_completo.services;


import org.springframework.stereotype.Service;

import ies.castillodeluna.mvc_completo.models.Pokemon;
import ies.castillodeluna.mvc_completo.repositories.PokemonRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PokemonCategoryServiceImpl implements PokemonCategoryService {

    private final PokemonRepository pokemonRepository;
    
    public PokemonCategoryServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    
    @Override
    public Map<String, List<Pokemon>> categorizePokemons() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        Map<String, List<Pokemon>> categories = Map.of(
                "debil", pokemons.stream().filter(p -> p.getHitPoints() < 100).collect(Collectors.toList()),
                "fuerte", pokemons.stream().filter(p -> p.getHitPoints() >= 100).collect(Collectors.toList())
        );
        return categories;
    }
}
