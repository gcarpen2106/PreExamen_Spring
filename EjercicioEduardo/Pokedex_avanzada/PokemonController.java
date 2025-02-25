package ies.castillodeluna.pokedex.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ies.castillodeluna.pokedex.models.Pokemon;
import ies.castillodeluna.pokedex.services.PokemonService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PokemonController {

    private final PokemonService pokemonService;
    
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }
    
    // Listar todos los Pokémon
    @GetMapping("/pokemons")
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }
    
    // Obtener un Pokémon por ID
    @GetMapping("/pokemons/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonService.getPokemonById(id);
        return pokemon.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // Crear un nuevo Pokémon
    @PostMapping("/pokemons")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    // Eliminar un Pokémon por ID
    @DeleteMapping("/pokemons/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
        if (pokemonService.getPokemonById(id).isPresent()) {
            pokemonService.deletePokemon(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // Actualizar el nivel de un Pokémon
    @PutMapping("/pokemons/{id}/level")
    public ResponseEntity<Pokemon> updatePokemonLevel(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        if (!body.containsKey("level")) {
            return ResponseEntity.badRequest().build();
        }
        int level = body.get("level");
        Pokemon updated = pokemonService.updatePokemonLevel(id, level);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }
    
    // Filtrar Pokémon por tipo
    @GetMapping("/pokemons/filter")
    public List<Pokemon> getPokemonsByType(@RequestParam String type) {
        return pokemonService.getPokemonsByType(type);
    }
    
    // Filtrar Pokémon por rango de hitPoints
    @GetMapping("/pokemons/hitpoints")
    public List<Pokemon> getPokemonsByHitPointsRange(@RequestParam Long min, @RequestParam Long max) {
        return pokemonService.getPokemonsByHitPointsRange(min, max);
    }
    
    // Consultar estadísticas de los Pokémon
    @GetMapping("/pokemons/stats")
    public Map<String, Object> getPokemonStats() {
        return pokemonService.getPokemonStats();
    }
}
