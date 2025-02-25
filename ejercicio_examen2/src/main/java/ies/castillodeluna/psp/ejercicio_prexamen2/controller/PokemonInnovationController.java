package ies.castillodeluna.psp.ejercicio_prexamen2.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ies.castillodeluna.psp.ejercicio_prexamen2.models.Pokemons;
import ies.castillodeluna.psp.ejercicio_prexamen2.models.PokemonsDTO;
import ies.castillodeluna.psp.ejercicio_prexamen2.service.PokemonServiceImpl;

@RestController
@RequestMapping("/api")
public class PokemonInnovationController {
    
    @Autowired
    private PokemonServiceImpl service;

    @GetMapping("/pokemons/advanced-filter")
    public List<Pokemons> findByAdvancedFilter(@RequestParam String type , @RequestParam Integer minLevel , @RequestParam Integer maxLevel){

        return service.findByAdvancedFilter(type, minLevel, maxLevel);
        
    }

    @GetMapping("/pokemons/legendary")
    public List<Pokemons> findByLegendary(@RequestParam Boolean legendario){

        return service.findByLegendary(legendario);        

    }

    @PutMapping("/pokemons/{id}/capture-rate")
    public void update(@PathVariable Long id , @RequestBody Map<String,Integer> body){

        Integer captureRate = body.get("captureRate");

        service.updateCaptureRate(id, captureRate);
        
    }

    @PostMapping("/pokemons/evolve")
    public Optional<Pokemons> registrarEvolucionPokemon(@RequestBody PokemonsDTO pokeDTO){

        Long id = pokeDTO.getId();
        Integer levelIncremet = pokeDTO.getLevel();
        Long hitPoints = pokeDTO.getHitPoints();
        String newEvolucion = pokeDTO.getEvolution();

        service.registrarEvolucion(id, levelIncremet, hitPoints, newEvolucion);
        return service.findById(id);

    }

    @DeleteMapping("/pokemons/{id}")
    public ResponseEntity<Optional> deletePokemonn(@PathVariable Long id){

        if (service.getPokemonById(id).isPresent()) {
            service.deletePokemonById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
