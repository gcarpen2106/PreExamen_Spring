package ies.castillodeluna.mvc_completo.services;


import org.springframework.stereotype.Service;

import ies.castillodeluna.mvc_completo.models.Pokemon;
import ies.castillodeluna.mvc_completo.repositories.PokemonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;
    
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    
    @Override
    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }
    
    @Override
    public List<Pokemon> getPokemonsByNamePrefix(String prefix) {
        return pokemonRepository.findByNameStartingWith(prefix);
    }
    
    @Override
    public List<Pokemon> getBuffedPokemonsByNamePrefix(String prefix) {
        return pokemonRepository.findByNameStartingWith(prefix)
                .stream().map(pokemon -> {
                    long buffedHitPoints = (long) (pokemon.getHitPoints() * 1.1);
                    return new Pokemon(pokemon.getId(), pokemon.getName(), pokemon.getType(), buffedHitPoints);
                }).collect(Collectors.toList());
    }
}
