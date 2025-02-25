package ies.castillodeluna.es.ejercicio_apipokemon.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ies.castillodeluna.es.ejercicio_apipokemon.models.Pokemon;
import ies.castillodeluna.es.ejercicio_apipokemon.services.PokemonCategoryServiceImpl;
import ies.castillodeluna.es.ejercicio_apipokemon.services.PokemonServiceImpl;

@RestController
@RequestMapping("/api")
public class PokemonController {
    
    @Autowired
    private PokemonCategoryServiceImpl service;

    @Autowired
    private PokemonServiceImpl service2;

    @GetMapping("/pokemons")
    public List<Pokemon> allPokemons(){

        return service.findAll();

    }

    @GetMapping("/categories")
    public Map<String, List<Pokemon>> showByHit(){

        Map<String, List<Pokemon>> pokemos = new HashMap<>();

        pokemos.put("Debil", service.findByLowHitPoint());
        pokemos.put("Fuerte", service.findByHighHitPoint());

        return pokemos;

    }

    @GetMapping("/pokemons/search")
    public Map<String, List<Pokemon>> showByPrefix(@RequestParam(name = "prefix",required = true) String prefix){

        Map<String, List<Pokemon>> pokemos = new HashMap<>();

        pokemos.put("Normal", service2.findByPrefix(prefix));
        pokemos.put("Buffed", service2.findByBuff(prefix));

        return pokemos;

    }

}
