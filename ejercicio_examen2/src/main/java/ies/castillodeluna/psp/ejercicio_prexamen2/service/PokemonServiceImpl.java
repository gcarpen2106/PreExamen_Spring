package ies.castillodeluna.psp.ejercicio_prexamen2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.castillodeluna.psp.ejercicio_prexamen2.models.Pokemons;
import ies.castillodeluna.psp.ejercicio_prexamen2.repository.PokemonRepository;

@Service
public class PokemonServiceImpl implements PokemonService{

    @Autowired
    private PokemonRepository repository;

    @Override
    public Optional<Pokemons> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Pokemons> getPokemonById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Pokemons> findByAdvancedFilter(String type, Integer minLevel, Integer maxLevel) {
        
        return repository.findByAdvancedFilter(type, minLevel, maxLevel);

    }

    @Override
    public List<Pokemons> findByLegendary(Boolean legendary) {
        
        return repository.findByLegendary(legendary);

    }

    @Override
    public void updateCaptureRate(Long id , Integer captureRate) {
        
        repository.findById(id).ifPresent(pok -> {

            if (captureRate >= 0 && captureRate <= 255) {
                pok.setCaptureRate(captureRate);
                repository.save(pok);
            }
            
        });

    }

    @Override
    public void registrarEvolucion(Long id, Integer levelIncrement, Long hitPointsIncrement, String newEvolution) {
        
        repository.findById(id).ifPresent(pok -> {
            pok.setLevel(pok.getLevel() + levelIncrement);
            pok.setHitPoints(pok.getHitPoints() + hitPointsIncrement);
            pok.setEvolution(pok.getEvolution() + newEvolution);
        });

    }

    @Override
    public Optional<Pokemons> deletePokemonById(Long id) {

        repository.deleteById(id);
        return null;

    }

    
    
}
