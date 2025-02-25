package ies.castillodeluna.psp.ejercicio_pokemon_avanzado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ies.castillodeluna.psp.ejercicio_pokemon_avanzado.models.Pokemons;

public interface PokemonRepository extends JpaRepository<Pokemons , Long>{

    @Query("SELECT p FROM Pokemons p WHERE p.type = ?1")
    List<Pokemons> findByType(String type);

    @Query("SELECT p FROM Pokemons p WHERE p.hitPoints BETWEEN ?1 AND ?2")
    List<Pokemons> findByHitPoints(Long min , Long max);

    @Query("SELECT AVG(p.level), AVG(p.hitPoints), p.type , COUNT(p) FROM Pokemons p GROUP BY p.type")
    List<Object[]> consultStats();
    
}
