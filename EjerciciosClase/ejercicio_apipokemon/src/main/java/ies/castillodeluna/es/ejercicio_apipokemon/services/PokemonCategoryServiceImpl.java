package ies.castillodeluna.es.ejercicio_apipokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.castillodeluna.es.ejercicio_apipokemon.models.Pokemon;
import ies.castillodeluna.es.ejercicio_apipokemon.repositories.PokemonRepository;

@Service
public class PokemonCategoryServiceImpl implements PokemonCategoryService{

    @Autowired
    private PokemonRepository repository;

    @Override
    public List<Pokemon> findAll() {
        
        return (List<Pokemon>) repository.findAll();

    }

    @Override
    public List<Pokemon> findByHighHitPoint() {
        
        return repository.findByHighHitPoint();

    }

    @Override
    public List<Pokemon> findByLowHitPoint() {
        
        return repository.findByLowHitPoint();

    }

    
    
}
