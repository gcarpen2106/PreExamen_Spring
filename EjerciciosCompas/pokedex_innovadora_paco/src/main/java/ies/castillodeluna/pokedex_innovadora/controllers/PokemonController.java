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

    /**
     * GET /api/pokemons
     * Obtiene todos los Pokémon.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons
     */
    @GetMapping("/pokemons")
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    /**
     * GET /api/pokemons/{id}
     * Obtiene un Pokémon por ID.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons/{id}
     */
    @GetMapping("/pokemons/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonService.getPokemonById(id);
        return pokemon.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * POST /api/pokemons
     * Crea un nuevo Pokémon.
     * En Postman:
     * - Método: POST
     * - URL: http://localhost:8080/api/pokemons
     * - Body: raw (JSON)
     * {
     *   "name": "Pikachu",
     *   "type": "Electric",
     *   "hitPoints": 35,
     *   "level": 5,
     *   "abilities": ["Static", "Lightning Rod"],
     *   "weight": 6.0,
     *   "region": "Kanto",
     *   "evolutionNumber": 1,
     *   "specialAttacks": ["Thunder Shock", "Quick Attack"],
     *   "defense": 40,
     *   "trainer": "Ash",
     *   "ps": 50,
     *   "pp": 30
     * }
     */
    @PostMapping("/pokemons")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * DELETE /api/pokemons/{id}
     * Elimina un Pokémon por ID.
     * En Postman:
     * - Método: DELETE
     * - URL: http://localhost:8080/api/pokemons/{id}
     */
    @DeleteMapping("/pokemons/{id}")
    public ResponseEntity<Optional<Void>> deletePokemon(@PathVariable Long id) {
        Optional<Void> result = pokemonService.deletePokemon(id);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * PUT /api/pokemons/{id}/level
     * Actualiza el nivel de un Pokémon.
     * En Postman:
     * - Método: PUT
     * - URL: http://localhost:8080/api/pokemons/{id}/level
     * - Body: raw (JSON)
     * {
     *   "level": 10
     * }
     */
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

    /**
     * GET /api/pokemons/filter
     * Filtra Pokémon por tipo.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons/filter?type={type}
     */
    @GetMapping("/pokemons/filter")
    public List<Pokemon> getPokemonsByType(@RequestParam String type) {
        return pokemonService.getPokemonsByType(type);
    }

    /**
     * GET /api/pokemons/hitpoints
     * Filtra Pokémon por rango de hitPoints.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons/hitpoints?min={min}&max={max}
     */
    @GetMapping("/pokemons/hitpoints")
    public List<Pokemon> getPokemonsByHitPointsRange(@RequestParam Long min, @RequestParam Long max) {
        return pokemonService.getPokemonsByHitPointsRange(min, max);
    }

    /**
     * GET /api/pokemons/stats
     * Consulta estadísticas de los Pokémon.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons/stats
     */
    @GetMapping("/pokemons/stats")
    public Map<String, Object> getPokemonStats() {
        return pokemonService.getPokemonStats();
    }

    /**
     * GET /api/pokemons/abilities
     * Filtra Pokémon por habilidades.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons/abilities?abilities={abilities}
     */
    @GetMapping("/pokemons/abilities")
    public List<Pokemon> getPokemonsByAbilities(@RequestParam List<String> abilities) {
        return pokemonService.getPokemonsByAbilities(abilities);
    }

    /**
     * PUT /api/pokemons/{id}/weight
     * Actualiza el peso de un Pokémon.
     * En Postman:
     * - Método: PUT
     * - URL: http://localhost:8080/api/pokemons/{id}/weight
     * - Body: raw (JSON)
     * {
     *   "weight": 7.0
     * }
     */
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

    /**
     * GET /api/pokemons/region
     * Filtra Pokémon por región.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons/region?region={region}
     */
    @GetMapping("/pokemons/region")
    public List<Pokemon> getPokemonsByRegion(@RequestParam String region) {
        return pokemonService.getPokemonsByRegion(region);
    }

    /**
     * GET /api/pokemons/evolution
     * Filtra Pokémon por número de evolución.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons/evolution?evolutionNumber={evolutionNumber}
     */
    @GetMapping("/pokemons/evolution")
    public List<Pokemon> getPokemonsByEvolutionNumber(@RequestParam Integer evolutionNumber) {
        return pokemonService.getPokemonsByEvolutionNumber(evolutionNumber);
    }

    /**
     * GET /api/pokemons/special-attack
     * Filtra Pokémon por ataque especial.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons/special-attack?specialAttack={specialAttack}
     */
    @GetMapping("/pokemons/special-attack")
    public List<Pokemon> getPokemonsBySpecialAttack(@RequestParam String specialAttack) {
        return pokemonService.getPokemonsBySpecialAttack(specialAttack);
    }

    /**
     * GET /api/pokemons/defense
     * Filtra Pokémon por defensa.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons/defense?defense={defense}
     */
    @GetMapping("/pokemons/defense")
    public List<Pokemon> getPokemonsByDefense(@RequestParam Integer defense) {
        return pokemonService.getPokemonsByDefense(defense);
    }

    /**
     * GET /api/pokemons/trainer
     * Filtra Pokémon por entrenador.
     * En Postman:
     * - Método: GET
     * - URL: http://localhost:8080/api/pokemons/trainer?trainer={trainer}
     */
    @GetMapping("/pokemons/trainer")
    public List<Pokemon> getPokemonsByTrainer(@RequestParam String trainer) {
        return pokemonService.getPokemonsByTrainer(trainer);
    }

    /**
     * POST /api/pokemons/region
     * Crea un nuevo Pokémon con región.
     * En Postman:
     * - Método: POST
     * - URL: http://localhost:8080/api/pokemons/region
     * - Body: raw (JSON)
     * {
     *   "name": "Pikachu",
     *   "type": "Electric",
     *   "hitPoints": 35,
     *   "level": 5,
     *   "abilities": ["Static", "Lightning Rod"],
     *   "weight": 6.0,
     *   "region": "Kanto",
     *   "evolutionNumber": 1,
     *   "specialAttacks": ["Thunder Shock", "Quick Attack"],
     *   "defense": 40,
     *   "trainer": "Ash",
     *   "ps": 50,
     *   "pp": 30
     * }
     */
    @PostMapping("/pokemons/region")
    public ResponseEntity<Pokemon> createPokemonWithRegion(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * POST /api/pokemons/evolution
     * Crea un nuevo Pokémon con número de evolución.
     * En Postman:
     * - Método: POST
     * - URL: http://localhost:8080/api/pokemons/evolution
     * - Body: raw (JSON)
     * {
     *   "name": "Pikachu",
     *   "type": "Electric",
     *   "hitPoints": 35,
     *   "level": 5,
     *   "abilities": ["Static", "Lightning Rod"],
     *   "weight": 6.0,
     *   "region": "Kanto",
     *   "evolutionNumber": 1,
     *   "specialAttacks": ["Thunder Shock", "Quick Attack"],
     *   "defense": 40,
     *   "trainer": "Ash",
     *   "ps": 50,
     *   "pp": 30
     * }
     */
    @PostMapping("/pokemons/evolution")
    public ResponseEntity<Pokemon> createPokemonWithEvolutionNumber(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * POST /api/pokemons/special-attack
     * Crea un nuevo Pokémon con ataque especial.
     * En Postman:
     * - Método: POST
     * - URL: http://localhost:8080/api/pokemons/special-attack
     * - Body: raw (JSON)
     * {
     *   "name": "Pikachu",
     *   "type": "Electric",
     *   "hitPoints": 35,
     *   "level": 5,
     *   "abilities": ["Static", "Lightning Rod"],
     *   "weight": 6.0,
     *   "region": "Kanto",
     *   "evolutionNumber": 1,
     *   "specialAttacks": ["Thunder Shock", "Quick Attack"],
     *   "defense": 40,
     *   "trainer": "Ash",
     *   "ps": 50,
     *   "pp": 30
     * }
     */
    @PostMapping("/pokemons/special-attack")
    public ResponseEntity<Pokemon> createPokemonWithSpecialAttack(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * POST /api/pokemons/defense
     * Crea un nuevo Pokémon con defensa.
     * En Postman:
     * - Método: POST
     * - URL: http://localhost:8080/api/pokemons/defense
     * - Body: raw (JSON)
     * {
     *   "name": "Pikachu",
     *   "type": "Electric",
     *   "hitPoints": 35,
     *   "level": 5,
     *   "abilities": ["Static", "Lightning Rod"],
     *   "weight": 6.0,
     *   "region": "Kanto",
     *   "evolutionNumber": 1,
     *   "specialAttacks": ["Thunder Shock", "Quick Attack"],
     *   "defense": 40,
     *   "trainer": "Ash",
     *   "ps": 50,
     *   "pp": 30
     * }
     */
    @PostMapping("/pokemons/defense")
    public ResponseEntity<Pokemon> createPokemonWithDefense(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * POST /api/pokemons/trainer
     * Crea un nuevo Pokémon con entrenador.
     * En Postman:
     * - Método: POST
     * - URL: http://localhost:8080/api/pokemons/trainer
     * - Body: raw (JSON)
     * {
     *   "name": "Pikachu",
     *   "type": "Electric",
     *   "hitPoints": 35,
     *   "level": 5,
     *   "abilities": ["Static", "Lightning Rod"],
     *   "weight": 6.0,
     *   "region": "Kanto",
     *   "evolutionNumber": 1,
     *   "specialAttacks": ["Thunder Shock", "Quick Attack"],
     *   "defense": 40,
     *   "trainer": "Ash",
     *   "ps": 50,
     *   "pp": 30
     * }
     */
    @PostMapping("/pokemons/trainer")
    public ResponseEntity<Pokemon> createPokemonWithTrainer(@RequestBody Pokemon pokemon) {
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * PUT /api/pokemons/{id}/region
     * Actualiza la región de un Pokémon.
     * En Postman:
     * - Método: PUT
     * - URL: http://localhost:8080/api/pokemons/{id}/region
     * - Body: raw (JSON)
     * {
     *   "region": "Johto"
     * }
     */
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

    /**
     * PUT /api/pokemons/{id}/evolution
     * Actualiza el número de evolución de un Pokémon.
     * En Postman:
     * - Método: PUT
     * - URL: http://localhost:8080/api/pokemons/{id}/evolution
     * - Body: raw (JSON)
     * {
     *   "evolutionNumber": 2
     * }
     */
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

    /**
     * PUT /api/pokemons/{id}/special-attack
     * Actualiza los ataques especiales de un Pokémon.
     * En Postman:
     * - Método: PUT
     * - URL: http://localhost:8080/api/pokemons/{id}/special-attack
     * - Body: raw (JSON)
     * {
     *   "specialAttacks": ["Thunderbolt", "Iron Tail"]
     * }
     */
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

    /**
     * PUT /api/pokemons/{id}/defense
     * Actualiza la defensa de un Pokémon.
     * En Postman:
     * - Método: PUT
     * - URL: http://localhost:8080/api/pokemons/{id}/defense
     * - Body: raw (JSON)
     * {
     *   "defense": 50
     * }
     */
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

    /**
     * PUT /api/pokemons/{id}/trainer
     * Actualiza el entrenador de un Pokémon.
     * En Postman:
     * - Método: PUT
     * - URL: http://localhost:8080/api/pokemons/{id}/trainer
     * - Body: raw (JSON)
     * {
     *   "trainer": "Ash"
     * }
     */
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

    /**
     * PUT /api/pokemons/{id}/ps
     * Actualiza los PS de un Pokémon.
     * En Postman:
     * - Método: PUT
     * - URL: http://localhost:8080/api/pokemons/{id}/ps
     * - Body: raw (JSON)
     * {
     *   "ps": 60
     * }
     */
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

    /**
     * PUT /api/pokemons/{id}/pp
     * Actualiza los PP de un Pokémon.
     * En Postman:
     * - Método: PUT
     * - URL: http://localhost:8080/api/pokemons/{id}/pp
     * - Body: raw (JSON)
     * {
     *   "pp": 40
     * }
     */
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

    /**
     * DELETE /api/pokemons/region/{region}
     * Elimina Pokémon por región.
     * En Postman:
     * - Método: DELETE
     * - URL: http://localhost:8080/api/pokemons/region/{region}
     */
    @DeleteMapping("/pokemons/region/{region}")
    public ResponseEntity<Optional<Void>> deletePokemonsByRegion(@PathVariable String region) {
        Optional<Void> result = pokemonService.deletePokemonsByRegion(region);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * DELETE /api/pokemons/evolution/{evolutionNumber}
     * Elimina Pokémon por número de evolución.
     * En Postman:
     * - Método: DELETE
     * - URL: http://localhost:8080/api/pokemons/evolution/{evolutionNumber}
     */
    @DeleteMapping("/pokemons/evolution/{evolutionNumber}")
    public ResponseEntity<Optional<Void>> deletePokemonsByEvolutionNumber(@PathVariable Integer evolutionNumber) {
        Optional<Void> result = pokemonService.deletePokemonsByEvolutionNumber(evolutionNumber);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * DELETE /api/pokemons/special-attack/{specialAttack}
     * Elimina Pokémon por ataque especial.
     * En Postman:
     * - Método: DELETE
     * - URL: http://localhost:8080/api/pokemons/special-attack/{specialAttack}
     */
    @DeleteMapping("/pokemons/special-attack/{specialAttack}")
    public ResponseEntity<Optional<Void>> deletePokemonsBySpecialAttack(@PathVariable String specialAttack) {
        Optional<Void> result = pokemonService.deletePokemonsBySpecialAttack(specialAttack);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * DELETE /api/pokemons/defense/{defense}
     * Elimina Pokémon por defensa.
     * En Postman:
     * - Método: DELETE
     * - URL: http://localhost:8080/api/pokemons/defense/{defense}
     */
    @DeleteMapping("/pokemons/defense/{defense}")
    public ResponseEntity<Optional<Void>> deletePokemonsByDefense(@PathVariable Integer defense) {
        Optional<Void> result = pokemonService.deletePokemonsByDefense(defense);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * DELETE /api/pokemons/trainer/{trainer}
     * Elimina Pokémon por entrenador.
     * En Postman:
     * - Método: DELETE
     * - URL: http://localhost:8080/api/pokemons/trainer/{trainer}
     */
    @DeleteMapping("/pokemons/trainer/{trainer}")
    public ResponseEntity<Optional<Void>> deletePokemonsByTrainer(@PathVariable String trainer) {
        Optional<Void> result = pokemonService.deletePokemonsByTrainer(trainer);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * DELETE /api/pokemons/ps
     * Elimina Pokémon por rango de PS.
     * En Postman:
     * - Método: DELETE
     * - URL: http://localhost:8080/api/pokemons/ps?min={min}&max={max}
     */
    @DeleteMapping("/pokemons/ps")
    public ResponseEntity<Optional<Void>> deletePokemonsByPsRange(@RequestParam Integer min, @RequestParam Integer max) {
        Optional<Void> result = pokemonService.deletePokemonsByPsRange(min, max);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * DELETE /api/pokemons/pp
     * Elimina Pokémon por rango de PP.
     * En Postman:
     * - Método: DELETE
     * - URL: http://localhost:8080/api/pokemons/pp?min={min}&max={max}
     */
    @DeleteMapping("/pokemons/pp")
    public ResponseEntity<Optional<Void>> deletePokemonsByPpRange(@RequestParam Integer min, @RequestParam Integer max) {
        Optional<Void> result = pokemonService.deletePokemonsByPpRange(min, max);
        return result.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}


/*
 * package ies.castillodeluna.pokedex_innovadora.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ies.castillodeluna.pokedex_innovadora.exceptions.InvalidPokemonIdException;
import ies.castillodeluna.pokedex_innovadora.exceptions.PokemonNotFoundException;
import ies.castillodeluna.pokedex_innovadora.exceptions.PokemonValidationException;
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

    @GetMapping("/pokemons")
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/pokemons/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonService.getPokemonById(id);
        if (pokemon.isEmpty()) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(pokemon.get());
    }

    @PostMapping("/pokemons")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        if (pokemon.getName() == null || pokemon.getType() == null) {
            throw new PokemonValidationException("El nombre y el tipo del Pokémon son obligatorios.");
        }
        Pokemon created = pokemonService.createPokemon(pokemon);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping("/pokemons/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
        Optional<Void> result = pokemonService.deletePokemon(id);
        if (result.isEmpty()) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/pokemons/{id}/level")
    public ResponseEntity<Pokemon> updatePokemonLevel(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        if (!body.containsKey("level")) {
            throw new PokemonValidationException("El campo 'level' es obligatorio.");
        }
        int level = body.get("level");
        Pokemon updated = pokemonService.updatePokemonLevel(id, level);
        if (updated == null) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/pokemons/{id}/weight")
    public ResponseEntity<Pokemon> updatePokemonWeight(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        if (!body.containsKey("weight")) {
            throw new PokemonValidationException("El campo 'weight' es obligatorio.");
        }
        double weight = body.get("weight");
        Pokemon updated = pokemonService.updatePokemonWeight(id, weight);
        if (updated == null) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/pokemons/{id}/region")
    public ResponseEntity<Pokemon> updatePokemonRegion(@PathVariable Long id, @RequestBody Map<String, String> body) {
        if (!body.containsKey("region")) {
            throw new PokemonValidationException("El campo 'region' es obligatorio.");
        }
        String region = body.get("region");
        Pokemon updated = pokemonService.updatePokemonRegion(id, region);
        if (updated == null) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/pokemons/{id}/evolution")
    public ResponseEntity<Pokemon> updatePokemonEvolutionNumber(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        if (!body.containsKey("evolutionNumber")) {
            throw new PokemonValidationException("El campo 'evolutionNumber' es obligatorio.");
        }
        int evolutionNumber = body.get("evolutionNumber");
        Pokemon updated = pokemonService.updatePokemonEvolutionNumber(id, evolutionNumber);
        if (updated == null) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/pokemons/{id}/special-attack")
    public ResponseEntity<Pokemon> updatePokemonSpecialAttack(@PathVariable Long id, @RequestBody Map<String, List<String>> body) {
        if (!body.containsKey("specialAttacks")) {
            throw new PokemonValidationException("El campo 'specialAttacks' es obligatorio.");
        }
        List<String> specialAttacks = body.get("specialAttacks");
        Pokemon updated = pokemonService.updatePokemonSpecialAttack(id, specialAttacks);
        if (updated == null) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/pokemons/{id}/defense")
    public ResponseEntity<Pokemon> updatePokemonDefense(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        if (!body.containsKey("defense")) {
            throw new PokemonValidationException("El campo 'defense' es obligatorio.");
        }
        int defense = body.get("defense");
        Pokemon updated = pokemonService.updatePokemonDefense(id, defense);
        if (updated == null) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/pokemons/{id}/trainer")
    public ResponseEntity<Pokemon> updatePokemonTrainer(@PathVariable Long id, @RequestBody Map<String, String> body) {
        if (!body.containsKey("trainer")) {
            throw new PokemonValidationException("El campo 'trainer' es obligatorio.");
        }
        String trainer = body.get("trainer");
        Pokemon updated = pokemonService.updatePokemonTrainer(id, trainer);
        if (updated == null) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/pokemons/{id}/ps")
    public ResponseEntity<Pokemon> updatePokemonPs(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        if (!body.containsKey("ps")) {
            throw new PokemonValidationException("El campo 'ps' es obligatorio.");
        }
        int ps = body.get("ps");
        Pokemon updated = pokemonService.updatePokemonPs(id, ps);
        if (updated == null) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/pokemons/{id}/pp")
    public ResponseEntity<Pokemon> updatePokemonPp(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        if (!body.containsKey("pp")) {
            throw new PokemonValidationException("El campo 'pp' es obligatorio.");
        }
        int pp = body.get("pp");
        Pokemon updated = pokemonService.updatePokemonPp(id, pp);
        if (updated == null) {
            throw new PokemonNotFoundException("Pokémon con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/pokemons/region/{region}")
    public ResponseEntity<Void> deletePokemonsByRegion(@PathVariable String region) {
        Optional<Void> result = pokemonService.deletePokemonsByRegion(region);
        if (result.isEmpty()) {
            throw new PokemonNotFoundException("No se encontraron Pokémon en la región " + region + ".");
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/pokemons/evolution/{evolutionNumber}")
    public ResponseEntity<Void> deletePokemonsByEvolutionNumber(@PathVariable Integer evolutionNumber) {
        Optional<Void> result = pokemonService.deletePokemonsByEvolutionNumber(evolutionNumber);
        if (result.isEmpty()) {
            throw new PokemonNotFoundException("No se encontraron Pokémon con el número de evolución " + evolutionNumber + ".");
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/pokemons/special-attack/{specialAttack}")
    public ResponseEntity<Void> deletePokemonsBySpecialAttack(@PathVariable String specialAttack) {
        Optional<Void> result = pokemonService.deletePokemonsBySpecialAttack(specialAttack);
        if (result.isEmpty()) {
            throw new PokemonNotFoundException("No se encontraron Pokémon con el ataque especial " + specialAttack + ".");
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/pokemons/defense/{defense}")
    public ResponseEntity<Void> deletePokemonsByDefense(@PathVariable Integer defense) {
        Optional<Void> result = pokemonService.deletePokemonsByDefense(defense);
        if (result.isEmpty()) {
            throw new PokemonNotFoundException("No se encontraron Pokémon con defensa mayor o igual a " + defense + ".");
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/pokemons/trainer/{trainer}")
    public ResponseEntity<Void> deletePokemonsByTrainer(@PathVariable String trainer) {
        Optional<Void> result = pokemonService.deletePokemonsByTrainer(trainer);
        if (result.isEmpty()) {
            throw new PokemonNotFoundException("No se encontraron Pokémon con el entrenador " + trainer + ".");
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/pokemons/ps")
    public ResponseEntity<Void> deletePokemonsByPsRange(@RequestParam Integer min, @RequestParam Integer max) {
        Optional<Void> result = pokemonService.deletePokemonsByPsRange(min, max);
        if (result.isEmpty()) {
            throw new PokemonNotFoundException("No se encontraron Pokémon con PS entre " + min + " y " + max + ".");
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/pokemons/pp")
    public ResponseEntity<Void> deletePokemonsByPpRange(@RequestParam Integer min, @RequestParam Integer max) {
        Optional<Void> result = pokemonService.deletePokemonsByPpRange(min, max);
        if (result.isEmpty()) {
            throw new PokemonNotFoundException("No se encontraron Pokémon con PP entre " + min + " y " + max + ".");
        }
        return ResponseEntity.noContent().build();
    }
}
 */