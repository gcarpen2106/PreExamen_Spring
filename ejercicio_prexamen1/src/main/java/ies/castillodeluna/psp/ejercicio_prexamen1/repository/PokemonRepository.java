package ies.castillodeluna.psp.ejercicio_prexamen1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ies.castillodeluna.psp.ejercicio_prexamen1.models.Pokemon;
import jakarta.transaction.Transactional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    
    @Modifying
    @Transactional
    @Query("delete from Pokemon p where p.level BETWEEN ?1 and ?2")
    Integer deleteByBetweenLevel(Integer minLevel, Integer maxLevel);

    @Query("select p from Pokemon p where p.name LIKE ?1")
    List<Pokemon> findByName(String name);

    @Query("select p from Pokemon p where p.level >= ?1")
    List<Pokemon> findByMinLevel(Integer minLevel);

}
