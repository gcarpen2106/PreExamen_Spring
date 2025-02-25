package ies.castillodeluna.pokedex_innovadora.services;

import org.springframework.stereotype.Service;

import ies.castillodeluna.pokedex_innovadora.models.Pokemon;
import ies.castillodeluna.pokedex_innovadora.repositories.PokemonRepository;

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
    public Optional<Void> deletePokemon(Long id) {
        if (pokemonRepository.existsById(id)) {
            pokemonRepository.deleteById(id);
            return Optional.empty();
        }
        return Optional.ofNullable(null);
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
    public List<Pokemon> getPokemonsByAbilities(List<String> abilities) {
        return pokemonRepository.findByAbilitiesContaining(abilities);
    }
    
    @Override
    public Pokemon updatePokemonWeight(Long id, double weight) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            pokemon.setWeight(weight);
            return pokemonRepository.save(pokemon);
        }
        return null; // Se podría lanzar una excepción personalizada si no se encuentra
    }
    
    @Override
    public List<Pokemon> getPokemonsByRegion(String region) {
        return pokemonRepository.findByRegion(region);
    }

    @Override
    public List<Pokemon> getPokemonsByEvolutionNumber(Integer evolutionNumber) {
        return pokemonRepository.findByEvolutionNumber(evolutionNumber);
    }

    @Override
    public List<Pokemon> getPokemonsBySpecialAttack(String specialAttack) {
        return pokemonRepository.findBySpecialAttacksContaining(specialAttack);
    }

    @Override
    public List<Pokemon> getPokemonsByDefense(Integer defense) {
        return pokemonRepository.findByDefenseGreaterThanEqual(defense);
    }

    @Override
    public List<Pokemon> getPokemonsByTrainer(String trainer) {
        return pokemonRepository.findByTrainer(trainer);
    }

    @Override
    public List<Pokemon> getPokemonsByPsRange(Integer min, Integer max) {
        return pokemonRepository.findByPsBetween(min, max);
    }

    @Override
    public List<Pokemon> getPokemonsByPpRange(Integer min, Integer max) {
        return pokemonRepository.findByPpBetween(min, max);
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

    @Override
    public Pokemon updatePokemonRegion(Long id, String region) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            pokemon.setRegion(region);
            return pokemonRepository.save(pokemon);
        }
        return null;
    }

    @Override
    public Pokemon updatePokemonEvolutionNumber(Long id, int evolutionNumber) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            pokemon.setEvolutionNumber(evolutionNumber);
            return pokemonRepository.save(pokemon);
        }
        return null;
    }

    @Override
    public Pokemon updatePokemonSpecialAttack(Long id, List<String> specialAttacks) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            pokemon.setSpecialAttacks(specialAttacks);
            return pokemonRepository.save(pokemon);
        }
        return null;
    }

    @Override
    public Pokemon updatePokemonDefense(Long id, int defense) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            pokemon.setDefense(defense);
            return pokemonRepository.save(pokemon);
        }
        return null;
    }

    @Override
    public Pokemon updatePokemonTrainer(Long id, String trainer) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            pokemon.setTrainer(trainer);
            return pokemonRepository.save(pokemon);
        }
        return null;
    }

    @Override
    public Pokemon updatePokemonPs(Long id, int ps) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            pokemon.setPs(ps);
            return pokemonRepository.save(pokemon);
        }
        return null;
    }

    @Override
    public Pokemon updatePokemonPp(Long id, int pp) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            pokemon.setPp(pp);
            return pokemonRepository.save(pokemon);
        }
        return null;
    }

    @Override
    public Optional<Void> deletePokemonsByRegion(String region) {
        List<Pokemon> pokemons = pokemonRepository.findByRegion(region);
        if (!pokemons.isEmpty()) {
            pokemonRepository.deleteAll(pokemons);
            return Optional.empty();
        }
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Void> deletePokemonsByEvolutionNumber(Integer evolutionNumber) {
        List<Pokemon> pokemons = pokemonRepository.findByEvolutionNumber(evolutionNumber);
        if (!pokemons.isEmpty()) {
            pokemonRepository.deleteAll(pokemons);
            return Optional.empty();
        }
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Void> deletePokemonsBySpecialAttack(String specialAttack) {
        List<Pokemon> pokemons = pokemonRepository.findBySpecialAttacksContaining(specialAttack);
        if (!pokemons.isEmpty()) {
            pokemonRepository.deleteAll(pokemons);
            return Optional.empty();
        }
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Void> deletePokemonsByDefense(Integer defense) {
        List<Pokemon> pokemons = pokemonRepository.findByDefenseGreaterThanEqual(defense);
        if (!pokemons.isEmpty()) {
            pokemonRepository.deleteAll(pokemons);
            return Optional.empty();
        }
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Void> deletePokemonsByTrainer(String trainer) {
        List<Pokemon> pokemons = pokemonRepository.findByTrainer(trainer);
        if (!pokemons.isEmpty()) {
            pokemonRepository.deleteAll(pokemons);
            return Optional.empty();
        }
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Void> deletePokemonsByPsRange(Integer min, Integer max) {
        List<Pokemon> pokemons = pokemonRepository.findByPsBetween(min, max);
        if (!pokemons.isEmpty()) {
            pokemonRepository.deleteAll(pokemons);
            return Optional.empty();
        }
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Void> deletePokemonsByPpRange(Integer min, Integer max) {
        List<Pokemon> pokemons = pokemonRepository.findByPpBetween(min, max);
        if (!pokemons.isEmpty()) {
            pokemonRepository.deleteAll(pokemons);
            return Optional.empty();
        }
        return Optional.ofNullable(null);
    }
}