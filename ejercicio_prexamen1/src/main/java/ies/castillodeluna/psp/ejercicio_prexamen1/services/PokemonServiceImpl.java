package ies.castillodeluna.psp.ejercicio_prexamen1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.castillodeluna.psp.ejercicio_prexamen1.models.Pokemon;
import ies.castillodeluna.psp.ejercicio_prexamen1.repository.PokemonRepository;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonRepository repository;

    @Override
    public List<Pokemon> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Pokemon> findByMinLevel(Integer minLevel) {
        return repository.findByMinLevel(minLevel);

    }

    @Override
    public Optional<Pokemon> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Pokemon> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void actualizarPokemon(Long id, String type) {

        repository.findById(id).ifPresent(p -> {

            p.setType(type);
            repository.save(p);
            
        });
    }

    @Override
    public Integer deletePokemon(Integer minLevel, Integer maxLevel) {

        return repository.deleteByBetweenLevel(minLevel, maxLevel);

    }

    @Override
    public void evolucionarPokemons(Long id, Integer levelIncrement, Long hitPoint) {

        repository.findById(id).ifPresent(p -> {

            p.setLevel(p.getLevel() + levelIncrement);
            p.setHitPoints(p.getHitPoints() + hitPoint);
            repository.save(p);

        });

    }

}
