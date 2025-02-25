package ies.castillodeluna.psp.ejercicio_pokemon_avanzado.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemons")
public class Pokemons {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String type;

    @Column(name = "hit_points" , nullable = false)
    Long hitPoints;

    @Column(nullable = false)
    Integer level;

    public Pokemons() {
    }

    public Pokemons(String name, String type, Long hitPoints, Integer level) {
        this.name = name;
        this.type = type;
        this.hitPoints = hitPoints;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Long hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Pokemons [name=" + name + ", type=" + type + ", hitPoints=" + hitPoints + ", level=" + level + "]";
    }
}
