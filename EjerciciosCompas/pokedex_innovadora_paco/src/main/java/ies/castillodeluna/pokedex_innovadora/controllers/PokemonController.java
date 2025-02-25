package ies.castillodeluna.pokedex_innovadora.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ies.castillodeluna.pokedex_innovadora.models.Pokemon;
import ies.castillodeluna.pokedex_innovadora.services.PokemonService;

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
    public ResponseEntity<Optional<Void>> deletePokemon(@PathVariable Long id) {
        Optional<Void> result = pokemonService.deletePokemon(id);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
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

    // Obtener Pokémon por habilidades
    @GetMapping("/pokemons/abilities")
    public List<Pokemon> getPokemonsByAbilities(@RequestParam List<String> abilities) {
        return pokemonService.getPokemonsByAbilities(abilities);
    }

    // Actualizar el peso de un Pokémon
    @PutMapping("/pokemons/{id}/weight")
    public ResponseEntity<Pokemon> updatePokemonWeight(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        if (!body.containsKey("weight")) {
            return ResponseEntity.badRequest().build();
        }
        double weight = body.get("weight");
        Pokemon updated = pokemonService.updatePokemonWeight(id, weight);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Filtrar Pokémon por región
    @GetMapping("/pokemons/region")
    public List<Pokemon> getPokemonsByRegion(@RequestParam String region) {
        return pokemonService.getPokemonsByRegion(region);
    }

    // Filtrar Pokémon por número de evolución
    @GetMapping("/pokemons/evolution")
    public List<Pokemon> getPokemonsByEvolutionNumber(@RequestParam Integer evolutionNumber) {
        return pokemonService.getPokemonsByEvolutionNumber(evolutionNumber);
    }

    // Filtrar Pokémon por ataque especial
    @GetMapping("/pokemons/special-attack")
    public List<Pokemon> getPokemonsBySpecialAttack(@RequestParam String specialAttack) {
        return pokemonService.getPokemonsBySpecialAttack(specialAttack);
    }

    // Filtrar Pokémon por defensa
    @GetMapping("/pokemons/defense")
    public List<Pokemon> getPokemonsByDefense(@RequestParam Integer defense) {
        return pokemonService.getPokemonsByDefense(defense);
    }

    // Filtrar Pokémon por entrenador
    @GetMapping("/pokemons/trainer")
    public List<Pokemon> getPokemonsByTrainer(@RequestParam String trainer) {
        return pokemonService.getPokemonsByTrainer(trainer);
    }

    // Crear un nuevo Pokémon con región
    @PostMapping("/pokemons/region")
    public ResponseEntity<Pokemon> createPokemonWithRegion(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Crear un nuevo Pokémon con número de evolución
    @PostMapping("/pokemons/evolution")
    public ResponseEntity<Pokemon> createPokemonWithEvolutionNumber(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Crear un nuevo Pokémon con ataque especial
    @PostMapping("/pokemons/special-attack")
    public ResponseEntity<Pokemon> createPokemonWithSpecialAttack(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Crear un nuevo Pokémon con defensa
    @PostMapping("/pokemons/defense")
    public ResponseEntity<Pokemon> createPokemonWithDefense(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Crear un nuevo Pokémon con entrenador
    @PostMapping("/pokemons/trainer")
    public ResponseEntity<Pokemon> createPokemonWithTrainer(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Actualizar la región de un Pokémon
    @PutMapping("/pokemons/{id}/region")
    public ResponseEntity<Pokemon> updatePokemonRegion(@PathVariable Long id, @RequestBody Map<String, String> body) {
        if (!body.containsKey("region")) {
            return ResponseEntity.badRequest().build();
        }
        String region = body.get("region");
        Pokemon updated = pokemonService.updatePokemonRegion(id, region);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Actualizar el número de evolución de un Pokémon
    @PutMapping("/pokemons/{id}/evolution")
    public ResponseEntity<Pokemon> updatePokemonEvolutionNumber(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        if (!body.containsKey("evolutionNumber")) {
            return ResponseEntity.badRequest().build();
        }
        int evolutionNumber = body.get("evolutionNumber");
        Pokemon updated = pokemonService.updatePokemonEvolutionNumber(id, evolutionNumber);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Actualizar los ataques especiales de un Pokémon
    @PutMapping("/pokemons/{id}/special-attack")
    public ResponseEntity<Pokemon> updatePokemonSpecialAttack(@PathVariable Long id, @RequestBody Map<String, List<String>> body) {
        if (!body.containsKey("specialAttacks")) {
            return ResponseEntity.badRequest().build();
        }
        List<String> specialAttacks = body.get("specialAttacks");
        Pokemon updated = pokemonService.updatePokemonSpecialAttack(id, specialAttacks);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Actualizar la defensa de un Pokémon
    @PutMapping("/pokemons/{id}/defense")
    public ResponseEntity<Pokemon> updatePokemonDefense(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        if (!body.containsKey("defense")) {
            return ResponseEntity.badRequest().build();
        }
        int defense = body.get("defense");
        Pokemon updated = pokemonService.updatePokemonDefense(id, defense);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Actualizar el entrenador de un Pokémon
    @PutMapping("/pokemons/{id}/trainer")
    public ResponseEntity<Pokemon> updatePokemonTrainer(@PathVariable Long id, @RequestBody Map<String, String> body) {
        if (!body.containsKey("trainer")) {
            return ResponseEntity.badRequest().build();
        }
        String trainer = body.get("trainer");
        Pokemon updated = pokemonService.updatePokemonTrainer(id, trainer);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Actualizar los PS de un Pokémon
    @PutMapping("/pokemons/{id}/ps")
    public ResponseEntity<Pokemon> updatePokemonPs(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        if (!body.containsKey("ps")) {
            return ResponseEntity.badRequest().build();
        }
        int ps = body.get("ps");
        Pokemon updated = pokemonService.updatePokemonPs(id, ps);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Actualizar los PP de un Pokémon
    @PutMapping("/pokemons/{id}/pp")
    public ResponseEntity<Pokemon> updatePokemonPp(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        if (!body.containsKey("pp")) {
            return ResponseEntity.badRequest().build();
        }
        int pp = body.get("pp");
        Pokemon updated = pokemonService.updatePokemonPp(id, pp);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Eliminar Pokémon por región
    @DeleteMapping("/pokemons/region/{region}")
    public ResponseEntity<Optional<Void>> deletePokemonsByRegion(@PathVariable String region) {
        Optional<Void> result = pokemonService.deletePokemonsByRegion(region);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Eliminar Pokémon por número de evolución
    @DeleteMapping("/pokemons/evolution/{evolutionNumber}")
    public ResponseEntity<Optional<Void>> deletePokemonsByEvolutionNumber(@PathVariable Integer evolutionNumber) {
        Optional<Void> result = pokemonService.deletePokemonsByEvolutionNumber(evolutionNumber);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Eliminar Pokémon por ataque especial
    @DeleteMapping("/pokemons/special-attack/{specialAttack}")
    public ResponseEntity<Optional<Void>> deletePokemonsBySpecialAttack(@PathVariable String specialAttack) {
        Optional<Void> result = pokemonService.deletePokemonsBySpecialAttack(specialAttack);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Eliminar Pokémon por defensa
    @DeleteMapping("/pokemons/defense/{defense}")
    public ResponseEntity<Optional<Void>> deletePokemonsByDefense(@PathVariable Integer defense) {
        Optional<Void> result = pokemonService.deletePokemonsByDefense(defense);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Eliminar Pokémon por entrenador
    @DeleteMapping("/pokemons/trainer/{trainer}")
    public ResponseEntity<Optional<Void>> deletePokemonsByTrainer(@PathVariable String trainer) {
        Optional<Void> result = pokemonService.deletePokemonsByTrainer(trainer);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Eliminar Pokémon por rango de PS
    @DeleteMapping("/pokemons/ps")
    public ResponseEntity<Optional<Void>> deletePokemonsByPsRange(@RequestParam Integer min, @RequestParam Integer max) {
        Optional<Void> result = pokemonService.deletePokemonsByPsRange(min, max);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Eliminar Pokémon por rango de PP
    @DeleteMapping("/pokemons/pp")
    public ResponseEntity<Optional<Void>> deletePokemonsByPpRange(@RequestParam Integer min, @RequestParam Integer max) {
        Optional<Void> result = pokemonService.deletePokemonsByPpRange(min, max);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}