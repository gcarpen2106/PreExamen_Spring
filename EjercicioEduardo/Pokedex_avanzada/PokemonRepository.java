package ies.castillodeluna.pokedex.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import ies.castillodeluna.pokedex.models.Pokemon;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByNameStartingWith(String prefix);
    List<Pokemon> findByType(String type);
    List<Pokemon> findByHitPointsBetween(Long min, Long max);
}
