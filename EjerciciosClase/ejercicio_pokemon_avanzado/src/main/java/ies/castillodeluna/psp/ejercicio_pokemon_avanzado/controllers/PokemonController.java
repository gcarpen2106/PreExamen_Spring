package ies.castillodeluna.psp.ejercicio_pokemon_avanzado.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ies.castillodeluna.psp.ejercicio_pokemon_avanzado.models.Pokemons;
import ies.castillodeluna.psp.ejercicio_pokemon_avanzado.service.PokemonServiceImpl;

@RestController
@RequestMapping("/api")
public class PokemonController {

    @Autowired
    private PokemonServiceImpl service;

    @GetMapping("/pokemons")
    public List<Pokemons> findAll() {
        return service.findAll();
    }

    @GetMapping("/pokemons/{id}")
    public Optional<Pokemons> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/pokemons")
    public void createPokemon(Pokemons pokemon) {
        service.createPokemon(pokemon);
    }

    @DeleteMapping("/pokemons/{id}")
    public void deletePokemon(@PathVariable Long id) {
        service.deletePokemon(id);
    }

    @PutMapping("/pokemons/{id}/level")
    public void updatePokemonLevel(@PathVariable Long id, @RequestBody Map<String, Integer> requestBody) {
        Integer newLevel = requestBody.get("level");
        service.updatePokemon(id, newLevel);
    }

    @GetMapping("/pokemons/filter")
    public List<Pokemons> findByType(@RequestBody Map<String, String> requestBody) {
        String type = requestBody.get("filter");
        return service.findByType(type);
    }

    @GetMapping("/pokemons/hitpoints")
    public List<Pokemons> findByHitPoints(@RequestParam Long min, @RequestParam Long max) {
        return service.findByHit(min, max);
    }

    @GetMapping("/pokemons/stats")
    public List<Object[]> showPokedex() {
        return service.showPokedex();
    }

}
