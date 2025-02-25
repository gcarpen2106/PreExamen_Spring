package ies.castillodeluna.pokedex.services;


import org.springframework.stereotype.Service;

import ies.castillodeluna.pokedex.models.Pokemon;
import ies.castillodeluna.pokedex.repositories.PokemonRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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
    public Optional<Pokemon> getPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }
    
    @Override
    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
    
    @Override
    public void deletePokemon(Long id) {
        if(pokemonRepository.existsById(id)) {
            pokemonRepository.deleteById(id);
        }
    }
    
    @Override
    public Pokemon updatePokemonLevel(Long id, int level) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            pokemon.setLevel(level);
            return pokemonRepository.save(pokemon);
        }
        return null; // Se podría lanzar una excepción personalizada si no se encuentra
    }
    
    @Override
    public List<Pokemon> getPokemonsByType(String type) {
        return pokemonRepository.findByType(type);
    }
    
    @Override
    public List<Pokemon> getPokemonsByHitPointsRange(Long min, Long max) {
        return pokemonRepository.findByHitPointsBetween(min, max);
    }
    
    @Override
    public Map<String, Object> getPokemonStats() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        
        double averageLevel = pokemons.stream()
                .mapToInt(Pokemon::getLevel)
                .average()
                .orElse(0);
        
        double averageHitPoints = pokemons.stream()
                .mapToLong(Pokemon::getHitPoints)
                .average()
                .orElse(0);
        
        Map<String, Long> countByType = pokemons.stream()
                .collect(Collectors.groupingBy(Pokemon::getType, Collectors.counting()));
        
        return Map.of(
            "averageLevel", averageLevel,
            "averageHitPoints", averageHitPoints,
            "countByType", countByType
        );
    }
}
