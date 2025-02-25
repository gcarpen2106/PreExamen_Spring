package ies.castillodeluna.mvc_completo.controllers;




import org.springframework.web.bind.annotation.*;

import ies.castillodeluna.mvc_completo.models.Pokemon;
import ies.castillodeluna.mvc_completo.services.PokemonCategoryService;
import ies.castillodeluna.mvc_completo.services.PokemonService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PokemonController {

    private final PokemonService pokemonService;
    private final PokemonCategoryService pokemonCategoryService;
    
    public PokemonController(PokemonService pokemonService,
                             PokemonCategoryService pokemonCategoryService) {
        this.pokemonService = pokemonService;
        this.pokemonCategoryService = pokemonCategoryService;
    }
    
    // Endpoint para listar todos los Pokémon
    @GetMapping("/pokemons")
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }
    
    // Endpoint para obtener Pokémon categorizados según sus puntos de vida
    @GetMapping("/categories")
    public Map<String, List<Pokemon>> getPokemonCategories() {
        return pokemonCategoryService.categorizePokemons();
    }
    
    // Endpoint para buscar Pokémon por prefijo, devolviendo la lista normal y la con buff (10% de aumento en hitPoints)
    @GetMapping("/pokemons/search")
    public Map<String, List<Pokemon>> searchPokemons(@RequestParam String prefix) {
        List<Pokemon> normalPokemons = pokemonService.getPokemonsByNamePrefix(prefix);
        List<Pokemon> buffedPokemons = pokemonService.getBuffedPokemonsByNamePrefix(prefix);
        return Map.of(
                "normal", normalPokemons,
                "buffed", buffedPokemons
        );
    }
}
