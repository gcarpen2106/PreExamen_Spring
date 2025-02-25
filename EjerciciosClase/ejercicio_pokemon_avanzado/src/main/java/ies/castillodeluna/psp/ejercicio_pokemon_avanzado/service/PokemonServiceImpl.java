package ies.castillodeluna.psp.ejercicio_pokemon_avanzado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.castillodeluna.psp.ejercicio_pokemon_avanzado.models.Pokemons;
import ies.castillodeluna.psp.ejercicio_pokemon_avanzado.repository.PokemonRepository;

@Service
public class PokemonServiceImpl implements PokemonService{

    @Autowired
    private PokemonRepository repository;

    @Override
    public List<Pokemons> findAll() {
        
        return repository.findAll();

    }

    @Override
    public Optional<Pokemons> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void createPokemon(Pokemons pokemon) {
        repository.save(pokemon);
    }

    @Override
    public void deletePokemon(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updatePokemon(Long id, Integer newLevel) {

        repository.findById(id).ifPresent(pokemon -> {
            pokemon.setLevel(newLevel);
            repository.save(pokemon);
        });

    }

    @Override
    public List<Pokemons> findByType(String type) {
        
        return repository.findByType(type);

    }

    @Override
    public List<Pokemons> findByHit(Long min, Long max) {

        return repository.findByHitPoints(min, max);
        
    }

    @Override
    public List<Object[]> showPokedex() {
        return repository.consultStats();
    }
    
}
