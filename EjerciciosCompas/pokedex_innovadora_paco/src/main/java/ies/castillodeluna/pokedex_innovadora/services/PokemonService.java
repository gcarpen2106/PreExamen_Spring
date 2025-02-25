package ies.castillodeluna.pokedex_innovadora.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import ies.castillodeluna.pokedex_innovadora.models.Pokemon;

public interface PokemonService {
    List<Pokemon> getAllPokemons();
    Optional<Pokemon> getPokemonById(Long id);
    Pokemon createPokemon(Pokemon pokemon);
    Optional<Void> deletePokemon(Long id);
    Pokemon updatePokemonLevel(Long id, int level);
    Pokemon updatePokemonWeight(Long id, double weight);
    List<Pokemon> getPokemonsByType(String type);
    List<Pokemon> getPokemonsByHitPointsRange(Long min, Long max);
    List<Pokemon> getPokemonsByAbilities(List<String> abilities);
    List<Pokemon> getPokemonsByRegion(String region);
    List<Pokemon> getPokemonsByEvolutionNumber(Integer evolutionNumber);
    List<Pokemon> getPokemonsBySpecialAttack(String specialAttack);
    List<Pokemon> getPokemonsByDefense(Integer defense);
    List<Pokemon> getPokemonsByTrainer(String trainer);
    List<Pokemon> getPokemonsByPsRange(Integer min, Integer max);
    List<Pokemon> getPokemonsByPpRange(Integer min, Integer max);
    Map<String, Object> getPokemonStats();

    Pokemon updatePokemonRegion(Long id, String region);
    Pokemon updatePokemonEvolutionNumber(Long id, int evolutionNumber);
    Pokemon updatePokemonSpecialAttack(Long id, List<String> specialAttacks);
    Pokemon updatePokemonDefense(Long id, int defense);
    Pokemon updatePokemonTrainer(Long id, String trainer);
    Pokemon updatePokemonPs(Long id, int ps);
    Pokemon updatePokemonPp(Long id, int pp);

    Optional<Void> deletePokemonsByRegion(String region);
    Optional<Void> deletePokemonsByEvolutionNumber(Integer evolutionNumber);
    Optional<Void> deletePokemonsBySpecialAttack(String specialAttack);
    Optional<Void> deletePokemonsByDefense(Integer defense);
    Optional<Void> deletePokemonsByTrainer(String trainer);
    Optional<Void> deletePokemonsByPsRange(Integer min, Integer max);
    Optional<Void> deletePokemonsByPpRange(Integer min, Integer max);
}