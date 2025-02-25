package ies.castillodeluna.psp.ejercicio_prexamen1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import ies.castillodeluna.psp.ejercicio_prexamen1.models.Pokemon;
import ies.castillodeluna.psp.ejercicio_prexamen1.models.PokemonEvolutionRequest;
import ies.castillodeluna.psp.ejercicio_prexamen1.services.PokemonServiceImpl;

@RestController
@RequestMapping("/api")
public class PokemonInnovationController {

    @Autowired
    private PokemonServiceImpl service;

    @GetMapping("/pokemons/all")
    public List<Pokemon> findAll() {

        return service.findAll();

    }

    @GetMapping("/pokemons/level/{minLevel}")
    public List<Pokemon> findByMinLevel(@PathVariable Integer minLevel) {

        return service.findByMinLevel(minLevel);

    }

    @DeleteMapping("/pokemons/range")
    public Map<String, Object> deletePokemonByLevel(@RequestParam Integer minLevel, @RequestParam Integer maxLevel) {

        Integer cantidadElimnada = service.deletePokemon(minLevel, maxLevel);

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Pokémon eliminados correctamente");
        response.put("cantidadEliminada", cantidadElimnada);

        return response;

    }

    @PostMapping("/pokemons/evolve")
    public void evolucionPokemon(@RequestBody PokemonEvolutionRequest base) {

        service.evolucionarPokemons(base.getId(), base.getLevelIncrement(), base.getHitPointsIncrement());

    }

    @PutMapping("/pokemons/{id}/type")
    public void actualizarPokemon(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {

        String newType = requestBody.get("newType");
        service.actualizarPokemon(id, newType);

    }

}
