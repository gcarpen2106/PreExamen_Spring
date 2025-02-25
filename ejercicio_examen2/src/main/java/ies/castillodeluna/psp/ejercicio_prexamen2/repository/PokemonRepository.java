package ies.castillodeluna.psp.ejercicio_prexamen2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ies.castillodeluna.psp.ejercicio_prexamen2.models.Pokemons;

public interface PokemonRepository extends JpaRepository<Pokemons , Long>{

    @Query("SELECT p FROM Pokemons p WHERE p.type = ?1 AND p.level BETWEEN ?2 AND ?3")
    List<Pokemons> findByAdvancedFilter(String type, Integer minLevel, Integer maxLevel);

    @Query("select p from Pokemons p WHERE p.legendary = ?1")
    List<Pokemons> findByLegendary(Boolean legendary);
}
