package ies.castillodeluna.pokedex_innovadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import ies.castillodeluna.pokedex_innovadora.models.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByNameStartingWith(String prefix);
    List<Pokemon> findByType(String type);
    List<Pokemon> findByHitPointsBetween(Long min, Long max);
    List<Pokemon> findByAbilitiesContaining(List<String> abilities);
    List<Pokemon> findByRegion(String region);
    List<Pokemon> findByEvolutionNumber(Integer evolutionNumber);
    List<Pokemon> findBySpecialAttacksContaining(String specialAttack);
    List<Pokemon> findByDefenseGreaterThanEqual(Integer defense);
    List<Pokemon> findByTrainer(String trainer);
    List<Pokemon> findByPsBetween(Integer min, Integer max);
    List<Pokemon> findByPpBetween(Integer min, Integer max);
}