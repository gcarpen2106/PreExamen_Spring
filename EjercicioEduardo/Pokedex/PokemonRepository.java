package ies.castillodeluna.mvc_completo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import ies.castillodeluna.mvc_completo.models.Pokemon;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByNameStartingWith(String prefix);
}
