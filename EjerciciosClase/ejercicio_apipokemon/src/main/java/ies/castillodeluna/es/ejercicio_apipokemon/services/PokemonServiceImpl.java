package ies.castillodeluna.es.ejercicio_apipokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.castillodeluna.es.ejercicio_apipokemon.models.Pokemon;
import ies.castillodeluna.es.ejercicio_apipokemon.repositories.PokemonRepository;

@Service
public class PokemonServiceImpl implements PokemonService{

    List<Pokemon> pokemons;

    @Autowired
    private PokemonRepository repository;

    @Override
    public List<Pokemon> findAll() {
        return (List<Pokemon>) repository.findAll();
    }

    @Override
    public List<Pokemon> findByBuff(String prefix) {
        
        Long hitPointsIncrement;

        pokemons = repository.findByPrefix(prefix);

        for (Pokemon pokemon : pokemons) {
            
            hitPointsIncrement = (long) (pokemon.getHitPoints() * 1.10);
            pokemon.setHitPoints(hitPointsIncrement);

        }

        return pokemons;

    }

    @Override
    public List<Pokemon> findByPrefix(String prefix) {
        
        return repository.findByPrefix(prefix);

    }
    
    

}
