package ies.castillodeluna.es.ejercicio_apipokemon.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ies.castillodeluna.es.ejercicio_apipokemon.models.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon,Long>{

    @Query("select p from Pokemon p where p.hitPoints < 100")
    List<Pokemon> findByLowHitPoint();

    @Query("select p from Pokemon p where p.hitPoints >= 100")
    List<Pokemon> findByHighHitPoint();

    @Query("select p from Pokemon p where p.name LIKE ?1%")
    List<Pokemon> findByPrefix(String prefix);
    
}
